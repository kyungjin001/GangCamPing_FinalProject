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
    public @ResponseBody CampingLikeDetailDTO campingLike(HttpSession session, CampingLikeDTO campingLikeDTO) {

        System.out.println("campingLikeController");
        String memberEmail = (String) session.getAttribute("loginEmail");
        System.out.println("campingLikeControllerMEmber="+memberEmail);
        Long campingLike = cls.save(campingLikeDTO, memberEmail);
        System.out.println("campingLikeControllerLike="+campingLike);

        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);
        System.out.println("campingLikeControllerME="+memberEntity);

        Optional<CampingEntity> camping = cr.findById(campingLikeDTO.getCampingId());
        System.out.println("campingLikeControllerCE="+camping);

        CampingLikeDetailDTO campingLikeDetailDTO = cls.findByMemberEntityAndCampingEntity(memberEntity,camping);
        System.out.println("campingLikeControllerCLD="+campingLikeDetailDTO.toString());
        return campingLikeDetailDTO;
    }
}
