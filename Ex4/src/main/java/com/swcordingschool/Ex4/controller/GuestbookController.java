package com.swcordingschool.Ex4.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/templates/guestbook")
@Log4j
public class GuestbookController {
 @GetMapping({"/", "/list"})
    public String list(){
     log.info("list..........");

     return "/templates/guestbook/list";
 }
}
