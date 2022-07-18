package com.java.multiple.ds.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.java.multiple.ds.api")
public class SpringBootMultipleDsApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultipleDsApplication.class, args);
	}
}