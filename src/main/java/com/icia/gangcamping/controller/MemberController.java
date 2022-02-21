package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.dto.MemberSaveDTO;
import com.icia.gangcamping.dto.MemberUpdateDTO;
import com.icia.gangcamping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.icia.gangcamping.common.SessionConst.LOGIN_EMAIL;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService ms;

    @PostMapping("/save")
    public String save(@ModelAttribute MemberSaveDTO memberSaveDTO){
        Long memberId = ms.save(memberSaveDTO);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("login") MemberLoginDTO memberLoginDTO, BindingResult bindingResult, HttpSession session){
        System.out.println("asdfsadfsadf454545352345");
        boolean loginResult = ms.login(memberLoginDTO);
        System.out.println(loginResult);

        if(loginResult){
            session.setAttribute(LOGIN_EMAIL,memberLoginDTO.getMemberEmail());
            Long loginId = ms.findByMemberId(memberLoginDTO.getMemberEmail());
            session.setAttribute("loginId",loginId);
            System.out.println(loginId);
            return "index";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping ("/update")
    public String update_form(Model model, HttpSession session){

        String memberEmail = (String) session.getAttribute(LOGIN_EMAIL);
        System.out.println("asdfb43325467777"+memberEmail);
        if(memberEmail != null){
            System.out.println("bbfdsbdsfb="+memberEmail);
            MemberDetailDTO member = ms.findByEmail(memberEmail);
            model.addAttribute("member",member);
        }else if(memberEmail == null){
            MemberDetailDTO member = ms.findById((Long) session.getAttribute("memberId"));
            model.addAttribute("member",member);

            System.out.println("asdfadsf!!!@!@!@!@");
        }
        return "/member/update";
    }

    @PutMapping("/{memberId}")
    public ResponseEntity update2(@RequestBody MemberUpdateDTO memberUpdateDTO){

        System.out.println("Adsfsdafsdaf");
        Long memberId = ms.update(memberUpdateDTO);
        return new ResponseEntity(HttpStatus.OK);
    }



    @GetMapping("myInfo")
    public String myInfo() {
        return "member/myInfo";
    }

    @GetMapping("bookList")
    public String bookList() {
        return "member/bookList";
    }

    @GetMapping("chat")
    public String chat() {
        return "member/chat";
    }

    @GetMapping("confirmPW")
    public String confirmPW() {
        return "member/confirmPW";
    }

    @GetMapping("shoppingList")
    public String shoppingList() {
        return "member/shoppingList";
    }

    @GetMapping("shoppingLike")
    public String shoppingLike() {
        return "member/shoppingLike";
    }




}
