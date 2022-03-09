package com.icia.gangcamping.controller;


import com.icia.gangcamping.dto.CampingDetailDTO;
import com.icia.gangcamping.dto.ReviewDetailDTO;
import com.icia.gangcamping.repository.ReviewRepository;
import com.icia.gangcamping.service.CampingService;
import com.icia.gangcamping.service.ReviewService;
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
    private final ReviewService rs;
    private final ReviewRepository rr;

    @RequestMapping("about")
    public String about() {
        return "about";
    }

    @RequestMapping("elements.html")
    public String elements() {
        return "elements";
    }

    @RequestMapping("contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("single_listing.html")
    public String single_listing() {
        return "single_listing";
    }

    @RequestMapping("offers.html")
    public String offers() {
        return "offers";
    }


    @RequestMapping("/")
    public String main(Model model) {


        List campingDetailDTOList = new ArrayList();
        for(int i=0;i<3;i++) {
            CampingDetailDTO campingDetailDTO = CampingDetailDTO.toCampingDetailDTO(cs.findById((int) (Math.random() * 1000)).get());
            if(campingDetailDTO.getCampingFileName()==null){
                i= i-1;
            }else {
                campingDetailDTOList.add(campingDetailDTO);
            }
        }
        List<ReviewDetailDTO> reviewList = new ArrayList<>();
        int max = rr.findAll().size();
        if(max>0) {
            for (int i = 0; i < 5; i++) {
                int rnd = (int) (Math.random() * 10) + 1;
                if (rnd > max) {
                    i = i - 1;
                } else {
                    System.out.println(rnd + "/" + max);
                    ReviewDetailDTO dto = rs.findById(rnd);
                    if (dto.getCampingFileName() == null) {
                        i = i - 1;
                    } else {
                        reviewList.add(dto);
                    }
                }
            }
        }

        List<CampingDetailDTO> recommendList = cs.findTop3AllOrderByCampingLikeCount();
        model.addAttribute("reviewList",reviewList);
        model.addAttribute("resultList",campingDetailDTOList);
        model.addAttribute("recommendList",recommendList);


        return "index";
    }










}





