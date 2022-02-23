package com.icia.gangcamping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/camping")
public class CampingController {

    @GetMapping("/reservation")
    public String reservation(){
    return null;
    }

    @GetMapping("/campingPay")
    public String campingPay_form(){
        return "/camping/campingPay";
    }
}
