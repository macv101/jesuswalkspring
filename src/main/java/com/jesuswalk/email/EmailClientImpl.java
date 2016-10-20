package com.jesuswalk.email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jesuswalk.response.EmailResponse;
import com.jesuswalk.response.ResponseStatus;
import com.sun.mail.imap.IMAPFolder;

@Component
public class EmailClientImpl implements EmailClient {

	@Value("${Email.Host}")
	private String host;

	@Value("${Email.StoreType}")
	private String storeType;

	public EmailResponse getMail(String email, String password) {

		EmailResponse ret;
		List<Mail> mails = new ArrayList<Mail>();

		try {

			// create properties field
			Properties properties = new Properties();

			properties.put("mail.store.protocol", storeType);
			Session emailSession = Session.getDefaultInstance(properties, null);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore(storeType);
			store.connect(host, email, password);

			// create the folder object and open it
			IMAPFolder emailFolder = (IMAPFolder) store.getFolder("INBOX");

			if (!emailFolder.isOpen())
				emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			
			// sort newest to oldest messages
			Arrays.sort(messages, (m1, m2) -> {
				try {
					return ((Message) m2).getSentDate().compareTo(((Message) m1).getSentDate());
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
			});

			for (Message message : messages) {
				mails.add(populateReader(message));
			}

			// set messages in response
			ret = new EmailResponse();
			ret.setMail(mails);

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (MessagingException e) {
			ret = new EmailResponse(ResponseStatus.INTERNAL_ERROR);
			ret.setMessage(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			ret = new EmailResponse(ResponseStatus.INTERNAL_ERROR);
			ret.setMessage(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			ret = new EmailResponse(ResponseStatus.INTERNAL_ERROR);
			ret.setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ret;

	}

	public EmailResponse sendMail(String email, String password, Mail mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	private Mail populateReader(Message message) throws Exception {
		Mail ret = new Mail();
		// Get Senders
		List<String> senders = new ArrayList<String>();
		for (Address recipientAddress : message.getFrom()) {
			String recipient = recipientAddress.toString();
			int ltIndex = recipient.indexOf('<');
			int atIndex = recipient.indexOf('@');
			int gtIndex = recipient.indexOf('>');
			if ((ltIndex != -1) && (atIndex != -1) && (gtIndex != -1) && (ltIndex < atIndex) && (atIndex < gtIndex)) {
				recipient = recipient.substring(ltIndex + 1, gtIndex);
			}
			senders.add(recipient);
		}

		// Get Recipients
		List<String> recipients = new ArrayList<String>();
		for (Address recipientAddress : message.getAllRecipients()) {
			String recipient = recipientAddress.toString();
			int ltIndex = recipient.indexOf('<');
			int atIndex = recipient.indexOf('@');
			int gtIndex = recipient.indexOf('>');
			if ((ltIndex != -1) && (atIndex != -1) && (gtIndex != -1) && (ltIndex < atIndex) && (atIndex < gtIndex)) {
				recipient = recipient.substring(ltIndex + 1, gtIndex);
			}
			recipients.add(recipient);
		}

		// Get Recipients
		List<String> headers = new ArrayList<String>();
		Enumeration enumHeaders = message.getAllHeaders();
		while (enumHeaders.hasMoreElements()) {
			Header header = (Header) enumHeaders.nextElement();
			headers.add(header.getName() + ": " + header.getValue());
		}

		ret.setTo(recipients);
		ret.setFrom(senders);
		ret.setHeaders(headers);
		ret.setContent(getTextFromMessage(message));
		ret.setSubject(message.getSubject());
		ret.setDateReceived(message.getSentDate());
		ret.setUnread(!message.isSet(Flags.Flag.SEEN));

		return ret;
	}

	private String getTextFromMessage(Message message) throws MessagingException, IOException, Exception {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
		String result = "";
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break; // without break same text appears twice in my tests
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent();
				result = result + "\n" + StringEscapeUtils.unescapeHtml4(html);
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
			}
		}
		return result;
	}
}
