package com.example.springboot.Lesson202;

//Step2. web application을 만든다.

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
//HellowController class가 @RearController로 플래그가 지정되어
//SpringMVC에서 웹 요청을 처리할 준비가 되었음을 의미함

public class HelloController {
	// '/'를 index()메서드에 매핑한다.
	@RequestMapping("/")
	public String index() {
		return "Hi, Nice to meet you. from spring boot...";
		
	}
}
