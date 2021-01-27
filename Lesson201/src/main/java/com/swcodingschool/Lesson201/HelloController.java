package com.swcodingschool.Lesson201;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //meaning it is ready for use by Spring MVC to handle web requests. 
public class HelloController {
	// maps / to the index() method. 
	// When invoked from a browser or by using curl on the command line, 
	// the method returns pure text.
	@RequestMapping("/")   
	public String index() {
		return "Greetings from Spring Boot!";
	}
	

}
