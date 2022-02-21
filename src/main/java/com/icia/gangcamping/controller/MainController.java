package com.icia.gangcamping.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MainController {
    @RequestMapping("/")
    public String main(){return "index";}
    @RequestMapping("about")
    public String osf() {
        return "about";
    }

    @RequestMapping("booking")
    public String ofa() {
        return "offers";
    }

    @RequestMapping("contact")
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


}





