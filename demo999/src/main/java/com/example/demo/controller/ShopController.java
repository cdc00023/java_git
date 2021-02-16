package com.example.demo.controller;

import com.example.demo.DTO.PageRequestDTO;
import com.example.demo.DTO.ShopDTO;
import com.example.demo.service.ShopService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/shop")
@Log4j2
public class ShopController {
    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping("/ex1")
    public void ex1() {

        log.info("ex1.................");
    }

    @GetMapping("/index")
    public String index() {
        log.info("index.................");

        return "redirect:/shop/index";
    }


    @GetMapping("/list")
    public String list() {

        return "redirect:/shop/list";
    }




    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("list............." + pageRequestDTO);
        model.addAttribute("result", service.getList(pageRequestDTO));
    }

    //게시글 등록을 위한 추가 처리
    @GetMapping("/register")
    public void register() {
        log.info("regiser get...");
    }

    @PostMapping("/register")
    public String registerPost(ShopDTO dto, RedirectAttributes redirectAttributes) {
        log.info("dto..." + dto);

        Long number = service.register(dto);
        redirectAttributes.addFlashAttribute("msg", number);
        return "redirect:/shop/list";
    }

}

