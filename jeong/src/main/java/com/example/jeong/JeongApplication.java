package com.example.jeong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JeongApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JeongApplication.class);
	}


	public static void main (String[]args){
		SpringApplication.run(JeongApplication.class, args);

	}

//	public static void main(String[] args) {
//		SpringApplication.run(JeongApplication.class, args);
//	}



}
