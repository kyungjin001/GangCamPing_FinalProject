package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.CampingPaySaveDTO;
import com.icia.gangcamping.service.CampingPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/camping")
@RequiredArgsConstructor
public class CampingController {

    private final CampingPayService cps;

    @GetMapping("/reservation")
    public String reservation(){
    return null;
    }

    @GetMapping("/campingPay")
    public String campingPay_form(){
        return "/camping/campingPay";
    }

    @PostMapping("/payment")
    public String payment(@ModelAttribute CampingPaySaveDTO campingPaySaveDTO){
        Long campingPayId = cps.save(campingPaySaveDTO);
        return "/member/bookList";
    }
}
