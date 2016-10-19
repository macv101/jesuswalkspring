package com.jesuswalk.controller;

import com.barcodelib.barcode.Linear;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import io.swagger.annotations.Api;

import com.google.api.services.sheets.v4.Sheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("service")
@RequestMapping(value = "service")
public class GoogleTestController {
/*    *//** Application name. *//*
    private static final String APPLICATION_NAME =
        "Google Sheets API Java Quickstart";

    *//** Directory to store user credentials for this application. *//*
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), "Documents/My Projects/JesusWalk/test.json");

    *//** Global instance of the {@link FileDataStoreFactory}. *//*
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    *//** Global instance of the JSON factory. *//*
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    *//** Global instance of the HTTP transport. *//*
    private static HttpTransport HTTP_TRANSPORT;

    *//** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart.json
     *//*
    private static final List<String> SCOPES =
        Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    *//**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws Exception 
     *//*
    public static Credential authorize() throws Exception {
        // Load client secrets.g
        InputStream in = new FileInputStream(new java.io.File(
                System.getProperty("user.home"), "Documents/My Projects/JesusWalk/client_secret.json"));
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    *//**
     * Build and return an authorized Sheets API client service.
     * @return an authorized Sheets API client service
     * @throws Exception 
     *//*
    public static Sheets getSheetsService() throws Exception {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    private List<String> fromSpreadsheet() throws Exception {
    	List<String> ret = new ArrayList<String>();
    	 Sheets service = getSheetsService();

         // Prints the names and majors of students in a sample spreadsheet:
         // https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
         String spreadsheetId = "1tUSkB4CLzkihLgjnAF9Vxu8VR-BCs0ujm78c3bX58BE";
         String range = "Class Data!B2:C";
         ValueRange response = service.spreadsheets().values()
             .get(spreadsheetId, range)
             .execute();
         List<List<Object>> values = response.getValues();
         if (values == null || values.size() == 0) {
             System.out.println("No data found.");
         } else {
           System.out.println("Name, Major");
           for (List row : values) {
             // Print columns A and E, which correspond to indices 0 and 4.
        	   ret.add(row.get(0) + " " + row.get(1));
           }
         }
    	return ret;
    }*/
    
    @RequestMapping(value = "/barcodes", method = RequestMethod.GET)
    public void getFile(HttpServletResponse response) {
       try {
    	   Linear linear = new Linear();
    	   linear.setType(Linear.CODE128);
    	   for (String name : fromSpreadsheet()) {
    		   linear.setData(name);
    		   linear.renderBarcode("C:/Users/Public/Documents/Student Barcode/" +name+ "-barcode.png");
    	   }
    	   
       } catch (Exception ex) {
    	   
       }
    }
    
    private List<String> fromSpreadsheet() {
    	List<String> ret = new ArrayList<String>();
    	 try
         {
             FileInputStream file = new FileInputStream(new File("C:/Users/Michael/Documents/My Projects/JesusWalk/jw.xlsx"));
  
             //Create Workbook instance holding reference to .xlsx file
             XSSFWorkbook workbook = new XSSFWorkbook(file);
  
             //Get first/desired sheet from the workbook
             XSSFSheet sheet = workbook.getSheetAt(0);
  
             //Iterate through each rows one by one
             Iterator<Row> rowIterator = sheet.iterator();
             while (rowIterator.hasNext()) 
             {
                 Row row = rowIterator.next();
                 //For each row, iterate through all the columns
                 Iterator<Cell> cellIterator = row.cellIterator();
                  
                 String value = "";
                 for(int i = 0; i < 2; i++) 
                 {
                     Cell cell = cellIterator.next();
                     value += cell.getStringCellValue()+ " ";
                 }
                 ret.add(value);
             }
             file.close();
         } 
         catch (Exception e) 
         {
             e.printStackTrace();
         }
    	return ret;
    }
    
    /*public static void main(String[] args) throws IOException {
        // Build a new authorized API client service.
        Sheets service = getSheetsService();

        // Prints the names and majors of students in a sample spreadsheet:
        // https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
        String spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
        String range = "Class Data!A2:E";
        ValueRange response = service.spreadsheets().values()
            .get(spreadsheetId, range)
            .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
          System.out.println("Name, Major");
          for (List row : values) {
            // Print columns A and E, which correspond to indices 0 and 4.
            System.out.printf("%s, %s\n", row.get(0), row.get(4));
          }
        }
    }*/


}
