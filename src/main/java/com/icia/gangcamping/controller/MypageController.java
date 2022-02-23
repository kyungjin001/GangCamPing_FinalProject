package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.service.BookService;
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

    @GetMapping("/shoppingList")
    public String shoppingList(){
        return "/member/shoppingList";
    }

    @GetMapping("/bookList")
    public String bookList(HttpSession session, Model model){
//        원래코드
//        String memberEmail = (String) session.getAttribute("memberEmail");
//        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);

//        테스트용 멤버
        Optional<MemberEntity> memberEntity = ms.findByMemberId(1L);
        System.out.println(memberEntity.get());
        List<BookDetailDTO> list = bs.findByMemberEntity(memberEntity.get());
        model.addAttribute("bookList",list);


        return "/member/bookList";
    }

    @GetMapping("/campingList")
    public String campingList(){
        return "/member/campingList";
    }
}
