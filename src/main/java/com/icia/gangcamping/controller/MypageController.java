package com.icia.gangcamping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @GetMapping("/shoppingList")
    public String shoppingList(){
        return "/mypage/shoppingList";
    }

    @GetMapping("/bookList")
    public String bookList(){
        return "/mypage/bookList";
    }

    @GetMapping("/campingList")
    public String campingList(){
        return "/mypage/campingList";
    }
}
