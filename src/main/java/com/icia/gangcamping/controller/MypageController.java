package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.BookSaveDTO;
import com.icia.gangcamping.dto.CampingDetailDTO;
import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.entity.BookEntity;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.service.BookService;
import com.icia.gangcamping.service.CampingService;
import com.icia.gangcamping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

    private final BookService bs;
    private final MemberService ms;
    private final CampingService cs;

    @GetMapping("/shoppingList")
    public String shoppingList() {
        return "/member/shoppingList";
    }

    @GetMapping("/bookList")
    public String bookList(HttpSession session, Model model, BookDetailDTO bookDetailDTO) {
        String memberEmail = (String) session.getAttribute("loginEmail");
        System.out.println("mpc="+memberEmail);
        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);

       /* CampingEntity campingEntity = cs.findByCampingId(bookDetailDTO1.getCampingId());
        bookDetailDTO.setCampingName(campingEntity.getCampingName());*/

        List<BookDetailDTO> list = bs.findByMemberEntity(memberEntity);

        model.addAttribute("bookList", list);

        return "/member/bookList";
    }


}
