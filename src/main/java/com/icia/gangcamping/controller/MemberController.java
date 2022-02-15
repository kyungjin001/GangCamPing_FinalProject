package com.icia.gangcamping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

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




}
