package com.jack.jackdawson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {
//		LiquibaseAutoConfiguration.class,
//		DataSourceAutoConfiguration.class,
//		ValidationAutoConfiguration.class,
//		HibernateJpaAutoConfiguration.class,
//		JpaRepositoriesAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class
//})
@SpringBootApplication
@ComponentScan
@ImportResource({"classpath:applicationContext.xml"})
@EnableAutoConfiguration
public class JackDawsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(JackDawsonApplication.class, args);
	}

}
