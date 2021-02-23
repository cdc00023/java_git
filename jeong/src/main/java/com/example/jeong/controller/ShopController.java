package com.example.jeong.controller;

import com.example.jeong.DTO.PageDTO;
import com.example.jeong.DTO.ShopDTO;
import com.example.jeong.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping
public class ShopController {
    private final ShopService service;

//    @Autowired
//    @GetMapping("/home")
//    public String home(Model model){
//       return "home";
//    }

//    @GetMapping("/shop")
//    public String shop(Model model){
//        return "shop";
//    }

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

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }

    @GetMapping("/list")
    public String list(Model model){
        return "list";
    }

    @GetMapping({"/"})
    public String home(){

        return "redirect:/home";
    }

    @GetMapping("/home")
    //public void home(PageDTO pageDTO, ShopDTO dto, Model model){
   public void home(PageDTO pageDTO, Model model){
        log.info("home............." + pageDTO);
        model.addAttribute("result", service.getList(pageDTO));
       // model.addAttribute("dto", service.dtoToEntity(dto));
    }

    @GetMapping("/shop")
    public void shop(PageDTO pageDTO, Model model){
        log.info("shop............." + pageDTO);
        model.addAttribute("result", service.getList(pageDTO));
    }


    @PostMapping("/register")
    public String registerPost(ShopDTO dto, RedirectAttributes redirectAttributes) {
        //log.info("dto..." + dto);

        Long productID = service.register(dto);
        redirectAttributes.addFlashAttribute("msg", productID);
        return "redirect:/home";
    }


    @GetMapping({"/read", "/modify"})
    public void read(long productID, @ModelAttribute("pageDTO") PageDTO pageDTO, Model model ){
        //log.info("productID: " + productID);
        ShopDTO dto = service.read(productID);
        model.addAttribute("dto", dto);
    }
    @PostMapping("/remove")
    public String remove(long productID, RedirectAttributes redirectAttributes){


       // log.info("productID: " + productID);

        service.remove(productID);

        redirectAttributes.addFlashAttribute("msg", productID);

        return "redirect:/shop";

    }

    @PostMapping("/modify")
    public String modify(ShopDTO dto,
                         @ModelAttribute("pageDTO") PageDTO pageDTO,
                         RedirectAttributes redirectAttributes) {


        //log.info("post modify.........................................");
        //log.info("dto: " + dto);

        service.modify(dto);

        redirectAttributes.addAttribute("page", pageDTO.getPage());
        redirectAttributes.addAttribute("type", pageDTO.getType());
        redirectAttributes.addAttribute("keyword", pageDTO.getKeyword());

        redirectAttributes.addAttribute("productID", dto.getProductID());


        return "redirect:/shop";
    }

}



