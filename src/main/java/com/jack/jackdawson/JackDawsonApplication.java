package com.jack.jackdawson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

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
public class JackDawsonApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JackDawsonApplication.class, args);
	}

	@Override//为了打包SpringBoot项目
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

}
