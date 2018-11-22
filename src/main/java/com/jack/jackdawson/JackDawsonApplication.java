package com.jack.jackdawson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:applicationContext.xml"})
public class JackDawsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(JackDawsonApplication.class, args);
	}

}
