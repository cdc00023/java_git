package com.example.jeong.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Log4j2
@Controller
@RequiredArgsConstructor
public class ShopController {
    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        return "shop";
    }

    @GetMapping("/cart")
    public String cart(Model model){ return "cart"; }

    @GetMapping("/shop-detail")
    public String shopDetail(Model model){ return "shop-detail"; }

    @GetMapping("/my-account")
    public String myAccount(Model model){ return "my-account"; }

    @GetMapping("/join")
    public String join(Model model){ return "join"; }

    @GetMapping("/login")
    public String login(Model model){ return "login"; }

    @GetMapping("/admin-home")
    public String adminHome(Model model){
        return "admin-home";
    }

    }



