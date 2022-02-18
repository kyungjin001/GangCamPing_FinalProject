package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.MailCodeDTO;
import com.icia.gangcamping.dto.MailDTO;
import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.service.MailService;
import com.icia.gangcamping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MemberService ms;
    private final MailService mas;

    @PostMapping("/pwMailCheck")
    public @ResponseBody String pwMailCheck(@RequestParam("memberEmail") String memberEmail){

        String result = ms.pwMailCheck(memberEmail);
        return result;
    }

    @PostMapping("/mailCode")
    public @ResponseBody String mailCode (HttpSession session, MailDTO mailDTO, Model model, MailCodeDTO mailCodeDTO, MemberDetailDTO memberDetailDTO){
        System.out.println("bgbg2222222");
         MemberDetailDTO Id = ms.findByEmail(memberDetailDTO.getMemberEmail());
        System.out.println(Id.toString());
         Long Id2 = Id.getMemberId();
         session.setAttribute("memberId", Id2);
        System.out.println("값아 좀 떠라= "+Id2);
        Long email = mas.mailSend(mailDTO, mailCodeDTO);

        System.out.println(memberDetailDTO.toString());

        String result="";

        if(email != null){
            model.addAttribute("check", mailCodeDTO);
            model.addAttribute("email", mailDTO);
            model.addAttribute("member", memberDetailDTO);
            result="ok";
        }else{
            result="no";
        }
        return result;

    }
}
