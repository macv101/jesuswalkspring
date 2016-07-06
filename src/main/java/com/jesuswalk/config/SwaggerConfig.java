package com.jesuswalk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("JesusWalk").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("Michael Villar", "jesuswalkyouth.com", "michaelv@jesuswalkyouth.com");
		return new ApiInfoBuilder().title("JesusWalk Spring REST with Swagger")
				.description("JesusWalk's RESTful API using SpringBoot and Swagger")
				.termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
				.contact(contact)
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").version("2.0")
				.build();
	}
	
}
