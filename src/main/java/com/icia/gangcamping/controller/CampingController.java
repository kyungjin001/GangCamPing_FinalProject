package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.CampingPayDetailDTO;
import com.icia.gangcamping.dto.CampingPaySaveDTO;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.repository.BookRepository;
import com.icia.gangcamping.repository.CampingRepository;
import com.icia.gangcamping.service.BookService;
import com.icia.gangcamping.service.CampingPayService;
import com.icia.gangcamping.service.CampingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/camping")
@RequiredArgsConstructor
public class CampingController {

    private final CampingPayService cps;
    private final BookService bs;
    private final CampingRepository cr;

    @GetMapping("/reservation")
    public String reservation(){
    return null;
    }

    @GetMapping("/campingPay")
    public String campingPay_form(){
        return "/camping/campingPay";
    }

    @PostMapping("/payment")
    public String payment(@ModelAttribute CampingPaySaveDTO campingPaySaveDTO, Model model){
        Long campingPayId = cps.save(campingPaySaveDTO);

        BookDetailDTO book = bs.findById(campingPaySaveDTO.getBookId());
        Optional<CampingEntity> camping = cr.findById(book.getCampingId());
        book.setCampingName(camping.get().getCampingName());
        if(camping.get().getCampingFileName()==null){
            book.setCampingFileName("/images/noImage.jpg");
        }else {
            book.setCampingFileName(camping.get().getCampingFileName());
        }
        model.addAttribute("book",book);

        return "/member/bookList";
    }
}
