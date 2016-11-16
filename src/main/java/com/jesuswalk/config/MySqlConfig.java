package com.jesuswalk.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySources({
	@PropertySource("file:./application.properties"),
	@PropertySource("file:./persistence.properties")
})
public class MySqlConfig {

	// ========================
	// DATASOURCE PROPERTIES
	// ========================
	@Value("${spring.datasource.username}")
	private String DB_USERNAME;

	@Value("${spring.datasource.password}")
	private String DB_PASSWORD;

	@Value("${spring.datasource.host}")
	private String DB_HOST;

	@Value("${spring.datasource.port}")
	private String DB_PORT;

	@Value("${spring.datasource.name}")
	private String DB_NAME;

	// ========================
	// HIBERNATE PROPERTIES
	// ========================
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String HIBERNATE_HBM2DDL_AUTO;
	
	@Value("${spring.jpa.show-sql}")
	private String HIBERNATE_SHOW_SQL;
	
	@Value("${spring.jpa.hibernate.naming-strategy}")
	private String HIBERNATE_NAMING_STRATEGY;
	
	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String HIBERNATE_DIALECT;

	public MySqlConfig() {	}

	private String resolveUrl() {
		
		System.out.println(DB_HOST);
		System.out.println(DB_PORT);
		System.out.println(DB_NAME);
		
		String jdbc = String.format("jdbc:mysql://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME);
		System.out.println(jdbc);
		
		return jdbc;

	}

	@Bean
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(resolveUrl());
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan("com.jesuswalk");

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
		jpaProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		jpaProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		entityManagerFactory.setJpaProperties(jpaProperties);

		return entityManagerFactory;
	}

}