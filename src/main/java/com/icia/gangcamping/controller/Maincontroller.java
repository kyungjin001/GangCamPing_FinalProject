package com.icia.gangcamping.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class Maincontroller {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("offers.html")
    public String of() {
        return "offers";
    }

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

    @RequestMapping("blog.html")
    public String cxxxcoxxf() {
        return "blog";

    }

    @RequestMapping("index.html")
    public String cxczcof() {
        return "index";
    }




    @RequestMapping("shopdetail.html")
    public String cxczcsof() {
        return "shopdetail";
    }

}
