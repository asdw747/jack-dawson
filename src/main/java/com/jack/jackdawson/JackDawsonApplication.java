package com.jack.jackdawson;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

@SpringBootApplication
@ImportResource({"classpath:applicationContext.xml"})
public class JackDawsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(JackDawsonApplication.class, args);
	}

}
