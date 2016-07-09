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
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("All").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
	@Bean
	public Docket financialApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("jwFinances").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/finance/*"))
				.build();
	}
	
	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("jwUsers").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/user/*"))
				.build();
	}
	
	private ApiInfo apiInfo() {
		Contact contact = new Contact("Michael Villar", "http://www.jesuswalkyouth.com", "michaelv@jesuswalkyouth.com");
		return new ApiInfoBuilder().title("JesusWalk Spring REST with Swagger")
				.description("JesusWalk's RESTful API using SpringBoot and Swagger")
				.termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
				.contact(contact)
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").version("2.0")
				.build();
	}
	
}
