package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.MailCodeDTO;
import com.icia.gangcamping.dto.MailCodeDetailDTO;
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
    public @ResponseBody
    MailCodeDetailDTO mailCode (HttpSession session,MailCodeDTO mailCodeDTO, MailCodeDetailDTO mailCodeDetailDTO){
        System.out.println("bgbg2222222");

        Long email = mas.mailSend(mailCodeDTO);

        MailCodeDetailDTO member = mas.findByMemberEmailAndEmailCode(mailCodeDTO.getMemberEmail(), mailCodeDTO.getEmailCode());
        session.setAttribute("memberId", member.getMemberId());
        System.out.println(mailCodeDTO.toString());
        System.out.println(mailCodeDTO.getMemberId());
        System.out.println(member.toString());


        /*String result="";

        if(email != null){
            result="ok";
        }else{
            result="no";
        }*/
        return member;

        // return mailCodeDTO;
    }

    @PostMapping("/codeCheck")
    public @ResponseBody  String codeCheck(@RequestParam("memberEmail") String memberEmail, @RequestParam("emailCode") String emailCode, Model model, MemberDetailDTO memberDetailDTO){
        System.out.println("됐나?");
        System.out.println("확인1= "+memberEmail);
        System.out.println("확인2= "+emailCode);
        String email = ms.pwMailCheck(memberEmail);
        String code = mas.findByEmailCode(emailCode);
        System.out.println("됐으면= "+email);
        System.out.println("됐으면2= "+code);




        if((email.equals("ok") && (code.equals("ok")))){
            return "ok";
        }else{
            return "no";
        }

    }
}
