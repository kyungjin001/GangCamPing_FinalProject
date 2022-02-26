package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.repository.BookRepository;
import com.icia.gangcamping.repository.CampingRepository;
import com.icia.gangcamping.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/camping")
@RequiredArgsConstructor
public class CampingController {

    private final CampingPayService cps;
    private final BookService bs;
    private final CampingRepository cr;
    private final CampingLikeService cls;
    private final MemberService ms;

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
        model.addAttribute("bookList",book);

        return "/member/bookList";
    }

    @PostMapping("/campingLike")
    public CampingLikeDetailDTO campingLike(HttpSession session, CampingLikeDTO campingLikeDTO) {

        String memberEmail = (String) session.getAttribute("loginEmail");
        Long campingLike = cls.save(campingLikeDTO, memberEmail);

        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);
        Optional<CampingEntity> camping = cr.findById(campingLikeDTO.getCampingId());
        CampingLikeDetailDTO campingLikeDetailDTO = cls.findMemberEntityAndCampingEntity(memberEntity,camping);
        return campingLikeDetailDTO;
    }
}
