package com.icia.gangcamping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    //별점순으로 정렬 100개
    @GetMapping("/ranking")
    public String ranking(){

        return "ranking";
    }
}
