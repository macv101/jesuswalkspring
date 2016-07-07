package com.jesuswalk.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MySqlConfig {

	/*
	 * Preferential Properties
	 */
	private String HIBERNATE_DIALECT; 				// SQL Syntax version. Determines deprecated/updated functions, methods, etc in SQL syntax
	private String HIBERNATE_SHOW_SQL; 				// Spring outputs the SQL statement used for request on the console
	private String HIBERNATE_HBM2DDL_AUTO; 			// Dev tool to create tables through Java code. IMPORTANT: DO NOT USE IN PRODUCTION
	private String ENTITYMANAGER_PACKAGES_TO_SCAN; 	// Tells Spring the packages to scan

	/*
	 * Essential Properties
	 */
	private String DB_DRIVER;
	private String DB_USERNAME;
	private String DB_PASSWORD;
	private String DB_URL;

	MySqlConfig() {
		InitSQLVariables();
	}

	private void InitSQLVariables() {
		String USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
		String PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
		String HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
		String PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
		String NAME = System.getenv("OPENSHIFT_APP_NAME");
		String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + NAME;

		DB_USERNAME = USERNAME;
		DB_PASSWORD = PASSWORD;
		DB_URL = URL;

		
		/*DB_USERNAME = "root"; 
		DB_PASSWORD = ""; 
		DB_URL = "jdbc:mysql://localhost:3306/jwtest";*/
		 

		DB_DRIVER = "com.mysql.jdbc.Driver";

		HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
		HIBERNATE_SHOW_SQL = "true";
		HIBERNATE_HBM2DDL_AUTO = "update";
		ENTITYMANAGER_PACKAGES_TO_SCAN = "com.jesuswalk";

	}

	/*
	 * Essential Public Objects needed to execute CRUD operations to MYSQL database
	 * -DataSource: Parent object that contains all connection properties
	 * -EntityManagerFactory: Factory that can be distributed to controllers 
	 */
	@Bean
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean  entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
		
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