package com.icia.gangcamping.controller;


import com.icia.gangcamping.dto.CampingDetailDTO;
import com.icia.gangcamping.service.CampingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Controller
public class MainController {
    private final CampingService cs;

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
    @RequestMapping("test")
    public String test() {
        return "te1st";
    }



    @RequestMapping("/")
    public String cxczcof(Model model) {
        List campingDetailDTOList = new ArrayList();
        for(int i=0;i<3;i++) {
            CampingDetailDTO campingDetailDTO = CampingDetailDTO.toCampingDetailDTO(cs.findById((int) (Math.random() * 1000)).get());
            if(campingDetailDTO.getCampingFileName()==null){
                i= i-1;
            }else {
                campingDetailDTOList.add(campingDetailDTO);
            }
        }
        System.out.println(campingDetailDTOList);
        model.addAttribute("resultList",campingDetailDTOList);


        return "index";
    }










}





