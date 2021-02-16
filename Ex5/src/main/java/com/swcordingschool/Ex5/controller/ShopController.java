package com.swcordingschool.Ex5.controller;

import com.swcordingschool.Ex5.dto.PageRequestDTO;
import com.swcordingschool.Ex5.dto.ShopDTO;
import com.swcordingschool.Ex5.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("shop")
@Log4j2
@RequiredArgsConstructor
public class ShopController {
    private final ShopService service;

    @GetMapping({"/"})
    public String index() {

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




    @GetMapping({"/read", "/modify"})
    public void read(long number, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model ){
        log.info("number: " + number);
        ShopDTO dto = service.read(number);
        model.addAttribute("dto", dto);
    }
    @PostMapping("/remove")
    public String remove(long number, RedirectAttributes redirectAttributes){


        log.info("number: " + number);

        service.remove(number);

        redirectAttributes.addFlashAttribute("msg", number);

        return "redirect:/shop/list";

    }

    @PostMapping("/modify")
    public String modify(ShopDTO dto,
                         @ModelAttribute("requestDTO") PageRequestDTO requestDTO,
                         RedirectAttributes redirectAttributes) {


        log.info("post modify.........................................");
        log.info("dto: " + dto);

        service.modify(dto);

        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("type", requestDTO.getType());
        redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());

        redirectAttributes.addAttribute("number", dto.getNumber());


        return "redirect:/shop/read";
    }
}

