package com.icia.gangcamping.controller;


import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.dto.MemberSaveDTO;
import com.icia.gangcamping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member/*")
public class MemberController {

    private final MemberService ms;

    @GetMapping("save")
    public String saveForm(Model model) {
        model.addAttribute("member", new MemberSaveDTO());
        return "member/save";
    }

    @PostMapping("save")
    public String save(@Validated @ModelAttribute("member") MemberSaveDTO memberSaveDTO, BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()) {
            return "member/save";
        }
        try {
            Long memberId = ms.save(memberSaveDTO);
        } catch (IllegalStateException e) {
            bindingResult.reject("emailCheck", e.getMessage());
            return "member/save";
        }
        return "redirect:/member/login";
    }

    @GetMapping("login")
    public String loginForm(Model model) {
        model.addAttribute("login", new MemberLoginDTO());
        return "member/login";
    }

    // 로그인 처리
    @PostMapping("login")
    public String login(@Validated @ModelAttribute("login") MemberLoginDTO memberLoginDTO, BindingResult bindingResult, HttpSession session){

        if(bindingResult.hasErrors()){
            return "member/login";
        }
        boolean loginResult = ms.login(memberLoginDTO);
        if(ms.login(memberLoginDTO)){
            session.setAttribute("loginEmail", memberLoginDTO.getMemberEmail());
            return "index";
        } else {
            // 로그인 결과를 글로벌 오류(Global Error) : 전체적인 오류를 체크하는 것
            bindingResult.reject("loginFail", "이메일 또는 비밀번호가 틀립니다!");
            return "member/login";
        }
    }

    @GetMapping("/update/{memberId}")
    public String updateForm(@PathVariable Long memberId, Model model) {
        BookDetailDTO member = ms.findById(memberId);
        model.addAttribute("member", member);
        return "member/update";
    }

    @PostMapping("emailCheck")
    @ResponseBody
    public String emailCheck(@RequestParam("memberEmail") String memberEmail) {
        if (ms.emailCheck(memberEmail)) {
            return "ok";
        } else {
            return "no";
        }
    }


    @GetMapping("mypage")
    public String mypage() {
        return "member/mypage";

    }

    @GetMapping("myInfo")
    public String myInfo() {
        return "member/myInfo";

    }
    @GetMapping("shoppingList")
    public String shoppingList() {
        return "member/shoppingList";

    }


    @GetMapping("bookList")
    public String bookList(Model model) {
        List<BookDetailDTO> bookList = ms.bookList();
        model.addAttribute("bookList", bookList);
        System.out.println(bookList);
        return "member/bookList";
    }


    @GetMapping("shoppingLike")
    public String shoppingLike() {
        return "member/shoppingLike";

    }

    @GetMapping("chat")
    public String chat() {
        return "member/chat";

    }


    @GetMapping("delete")
    public String delete() {
        return "member/delete";

    }

    @GetMapping("shoppingDetail")
    public String shoppingDetail() {
        return "member/shoppingDetail";

    }


    @GetMapping("bookDetail")
    public String bookDetail() {
        return "member/bookDetail";

    }
    @GetMapping("addrChange")
    public String addrChange() {
        return "member/addrChange";

    }

    @GetMapping("confirmPW")
    public String confirmPW() {
        return "member/confirmPW";

    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

}
