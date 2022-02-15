package com.icia.gangcamping.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class MainController {


    @RequestMapping("about.html")
    public String osf() {
        return "about";
    }

    @RequestMapping("elements.html")
    public String ofa() {
        return "elements";
    }

    @RequestMapping("contact.html")
    public String cof() {
        return "contact";
    }

    @RequestMapping("single_listing.html")
    public String ccxxof() {
        return "single_listing";
    }

    @RequestMapping("offers.html")
    public String sssss() {
        return "offers";
    }

    @RequestMapping("index.html")
    public String cxczcof() {
        return "indexs";
    }

    @RequestMapping("/chat")
    public ModelAndView chat() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chat");
        return mv;
    }





}





