package com.koreait.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@GetMapping("/list")
	public String list() {
		
		log.info("list 호출되어버렸다..................");
		return "/sample/list"; //절대경로 지정
		
	}
	
	@GetMapping("/list2")
	public String list2() {
		
		log.info("list2 호출되어버렸다..................");
		return "/sample/list2"; //절대경로 지정
		
	}

}
