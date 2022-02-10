package com.icia.gangcamping.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/shopping/*")
public class shoppingcontroller {


    @RequestMapping("blog")
    public String blog() {
        return "shopping/blog";

    }


    @RequestMapping("shopdetail")
    public String shopDetail() {
        return "shopping/shopdetail";
    }

    @RequestMapping("cart")
    public String cart() {
        return "shopping/cart";
    }



}
