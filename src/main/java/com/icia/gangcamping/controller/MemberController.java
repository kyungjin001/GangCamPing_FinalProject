package com.icia.gangcamping.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member/*")
public class MemberController {


    @RequestMapping("mypage")
    public String mypage() {
        return "member/mypage";

    }

    @RequestMapping("myInfo")
    public String myInfo() {
        return "member/myInfo";

    }
    @RequestMapping("shoppingList")
    public String shoppingList() {
        return "member/shoppingList";

    }

    @RequestMapping("bookList")
    public String bookList() {
        return "member/bookList";

    }
    @RequestMapping("shoppingLike")
    public String shoppingLike() {
        return "member/shoppingLike";

    }

    @RequestMapping("chat")
    public String chat() {
        return "member/chat";

    }


    @RequestMapping("delete")
    public String delete() {
        return "member/delete";

    }

    @RequestMapping("shoppingDetail")
    public String shoppingDetail() {
        return "member/shoppingDetail";

    }


    @RequestMapping("bookDetail")
    public String bookDetail() {
        return "member/bookDetail";

    }
    @RequestMapping("addrChange")
    public String addrChange() {
        return "member/addrChange";

    }

    @RequestMapping("confirmPW")
    public String confirmPW() {
        return "member/confirmPW";

    }

}
