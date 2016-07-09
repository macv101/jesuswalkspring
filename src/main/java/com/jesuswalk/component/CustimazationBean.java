package com.jesuswalk.component;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

public class CustimazationBean implements EmbeddedServletContainerCustomizer{

	public void customize(ConfigurableEmbeddedServletContainer container) {
		// Can be used to change the context root and other pathing
	}

}
