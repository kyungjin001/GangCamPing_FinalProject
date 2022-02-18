package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {
    private final MemberService ms;

    @GetMapping("mypage")
    public String mypage() {

        return "member/mypage";
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
    // 로그인 처리
    @PostMapping("login")
    public String login(@Validated @ModelAttribute("login") MemberLoginDTO memberLoginDTO, BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors()) {
            return "member/login";
        }
        boolean loginResult = ms.login(memberLoginDTO);
        if (ms.login(memberLoginDTO)) {
            session.setAttribute("memberEmail", memberLoginDTO.getMemberEmail());
            return "member/mypage";
        } else {
            // 로그인 결과를 글로벌 오류(Global Error) : 전체적인 오류를 체크하는 것
            bindingResult.reject("loginFail", "이메일 또는 비밀번호가 틀립니다!");
            return "member/login";
        }
    }



}
