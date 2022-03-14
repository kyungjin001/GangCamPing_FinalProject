package com.icia.gangcamping.controller;


import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Fetch;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.icia.gangcamping.common.SessionConst.LOGIN_EMAIL;



@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService ms;
    private final MailService mail;
    private final BookService bs;
    private final CampingLikeService cls;
    private final HttpSession session;
    private final ShoppingService ss;
    private final ShoppingLikeService sls;
    private final OrderService os;
    



    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("member") MemberSaveDTO memberSaveDTO) {

        Long memberId = ms.save(memberSaveDTO);
        return "index";
    }

    // 네이버 로그인
    @RequestMapping(value="naverLogin", method=RequestMethod.GET)
    public String naverLogin() {
        return "index";
    }

//    회원가입 with Validation
//    @PostMapping("save")
//    public String save(@Validated @ModelAttribute("member") MemberSaveDTO memberSaveDTO, BindingResult bindingResult) throws IOException {
//        if(bindingResult.hasErrors()) {
//            return "member/save";
//        }
//        try {
//            Long memberId = ms.save(memberSaveDTO);
//        } catch (IllegalStateException e) {
//            bindingResult.reject("emailCheck", e.getMessage());
//            return "member/save";
//        }
//        return "redirect:/member/login";
//    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("login", new MemberLoginDTO());
        return "/member/login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("login") MemberLoginDTO memberLoginDTO, HttpSession session) {

        boolean loginResult = ms.login(memberLoginDTO);

        if (ms.login(memberLoginDTO)) {
            session.setAttribute("loginEmail", memberLoginDTO.getMemberEmail());
            Long loginId = ms.findByMemberId(memberLoginDTO.getMemberEmail());
            session.setAttribute("loginId",loginId);
            return "redirect:/";
        } else {
            return "member/loginError";
        }
    }

    @PostMapping("/login2")
    public @ResponseBody String login(@RequestParam("loginEmail") String loginEmail, @RequestParam("loginPw") String loginPw) {

        System.out.println(loginEmail);
        System.out.println(loginPw);
        MemberEntity memberEntity = ms.findByMemberEmail(loginEmail);
        System.out.println(memberEntity.getMemberEmail());
        System.out.println(memberEntity.getMemberPw());
        System.out.println("login="+memberEntity.toString());

        if (memberEntity != null) {
            System.out.println("이거느 ㄴ 나와?");
            if (memberEntity.getMemberPw().equals(loginPw)) {
                System.out.println("이거느 ㄴ 나와?2");
                session.setAttribute("loginEmail", memberEntity.getMemberEmail());
                Long loginId = ms.findByMemberId(memberEntity.getMemberEmail());
                session.setAttribute("loginId", loginId);
                System.out.println(session.getAttribute("loginEmail"));
                System.out.println(loginId);
                String redirectURL = (String) session.getAttribute("redirectURL");
                System.out.println(redirectURL);
                if (redirectURL != null) {
                    System.out.println("이거느 ㄴ 나와?3");
                    // return "redirect:" + redirectURL;
                        return "ok2";
                } else {
                    System.out.println("이거느 ㄴ 나와?4");
                    return "ok";
                }
            } else {
                return "no";
            }
        }else{
            return "no";
        }

    }

    // 로그인 처리 with Validation
//    @PostMapping("login")
//    public String login(@Validated @ModelAttribute("login") MemberLoginDTO memberLoginDTO, BindingResult bindingResult, HttpSession session){
//        if(bindingResult.hasErrors()){
//            return "redirect:/";
//        }
//        boolean loginResult = ms.login(memberLoginDTO);
//        if(ms.login(memberLoginDTO)){
//            session.setAttribute("loginEmail", memberLoginDTO.getMemberEmail());
//            return "redirect:/";
//        } else {
//            bindingResult.reject("loginFail", "이메일 또는 비밀번호가 틀립니다!");
//            return "redirect:/";
//        }
//    }


    // 로그인 처리 with Interceptor
//    @PostMapping("/login")
//    public String login(@Validated @ModelAttribute("login") MemberLoginDTO memberLoginDTO, HttpSession session){
//        boolean loginResult = ms.login(memberLoginDTO);
//        if(ms.login(memberLoginDTO)){
//            session.setAttribute("loginEmail", memberLoginDTO.getMemberEmail());
//            String redirectURL = (String) session.getAttribute("redirectURL");
//            if (redirectURL != null) {
//            return "redirect:" + redirectURL;
//            } else {
//               return "redirect:/";
//            }
//          } else{
//            return"member/login";
//          }



    // 이메일 중복 체크
    @PostMapping("/emailDp")
    @ResponseBody
    public String emailDp(@RequestParam("memberEmail") String memberEmail) {
        System.out.println("emailDP() :" + memberEmail);
        String result = ms.emailDp(memberEmail);
        return result;
    }

    // 로그인 오류시 알림
//    @PostMapping("/loginCheck")
//    @ResponseBody
//    public String loginCheck(@RequestParam("memberEmail") MemberLoginDTO memberLoginDTO) {
//        String result = ms.loginCheck(new MemberLoginDTO());
//        return result;
//    }


    //마이페이지
    @GetMapping("/{memberId}")
    public String mypage() {
        return "member/mypage";
    }

    /*@GetMapping("{memberEmail}")
    public String findById(HttpSession session, @PathVariable("memberEmail") String memberEmail, Model model) {
        String memberEmail1 = (String)session.getAttribute("loginEmail");
        MemberDetailDTO member = MemberDetailDTO.toMemberDetailDTO(ms.findByMemberEmail(memberEmail1));
        model.addAttribute("member", member);
        return "member/mypage";

    }*/



    @GetMapping("/update")
    public String updateForm(Model model, HttpSession session) {
        System.out.println(session.getAttribute("loginEmail"));
        String memberEmail = (String) session.getAttribute("loginEmail");
        if(memberEmail != null){
            System.out.println("bbfdsbdsfb="+memberEmail);
            MemberDetailDTO member = ms.findByEmail(memberEmail);
            model.addAttribute("member",member);
        }else if(memberEmail == null){
            MemberDetailDTO member = ms.findById((Long) session.getAttribute("memberId"));
            model.addAttribute("member",member);

            System.out.println("asdfadsf!!!@!@!@!@");
        }
        return "member/update";
    }

    @PostMapping("/updateAddr")
   public String updateAddr(HttpSession session, @ModelAttribute MemberUpdateDTO memberUpdateDTO, Model model){

       MemberDetailDTO member = ms.updateAddr(memberUpdateDTO);
       model.addAttribute("member", member);
       return "member/update";
   }

//    @PostMapping("/update")
//    public String update(@ModelAttribute MemberUpdateDTO memberUpdateDTO) {
//        Long memberId = ms.update(memberUpdateDTO);
//        return "member/update";
//        return "redirect:/member/" + memberUpdateDTO.getMemberId();
//    }


    @PutMapping("/{memberId}")
    public ResponseEntity update(@ModelAttribute MemberUpdateDTO memberUpdateDTO) throws IllegalStateException, IOException{
        System.out.println(memberUpdateDTO);
        Long memberId = ms.update(memberUpdateDTO);
        System.out.println("updaet="+memberUpdateDTO.toString());
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/confirmPW")
    public String confirmPWForm(Model model, HttpSession session,@RequestParam(value = "inputCode",required = false) String codeInput) {
        System.out.println(codeInput);

         if(!(codeInput==null)){
            String memberEmail = mail.findByMail(codeInput);
            MemberDetailDTO member = ms.findByEmail(memberEmail);
            model.addAttribute("member",member);
             System.out.println("confirm="+member.toString());
        }else{
             System.out.println(session.getAttribute("loginEmail"));
             String memberEmail = (String) session.getAttribute("loginEmail");
             MemberDetailDTO member = ms.findByEmail(memberEmail);
             model.addAttribute("member", member);
             System.out.println(member);
           }
        return "member/confirmPW";
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteById(HttpSession session, @PathVariable("memberId") Long memberId){
        ms.deleteById(memberId);
        session.invalidate();
        return new ResponseEntity(HttpStatus.OK);
    }


    //로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

   /* @GetMapping("/bookList/{memberEmail}")
    public String bookList(@PathVariable("memberEmail") String memberEmail) {

        MemberDetailDTO member = MemberDetailDTO.toMemberDetailDTO(ms.findByMemberEmail(memberEmail));
        BookDetailDTO book = bs.findByMemberId(member.getMemberId());

        return "member/bookList";
    }*/

//    @GetMapping("/shoppingLike")
//    public String shoppingLike(Model model, HttpSession session) {
//
//        String memberEmail = (String) session.getAttribute("loginEmail");
//        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);
//        /*List<ShoppingLikeDetailDTO> slList = sls.findByMemberEntity(memberEntity);
//        System.out.println(slList);
//        model.addAttribute("slList", slList);*/
//
//        List<CampingLikeDetailDTO> campingLike = cls.findByMemberEntity(memberEntity);
//        System.out.println(campingLike.toString());
//        model.addAttribute("campingLike", campingLike);
//
//        return "member/shoppingLike";
//    }


    @GetMapping("/delete")
    public String delete(HttpSession session, Model model) {
        String member = (String) session.getAttribute("loginEmail");
        MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(ms.findByMemberEmail(member));
        model.addAttribute("member",memberDetailDTO);

        return "member/delete";

    }

    @GetMapping("/shoppingDetail")
    public String shoppingDetail() {
        return "member/shoppingDetail";

    }



    @GetMapping("/bookDetail")
    public String bookDetail() {
        return "member/bookDetail";

    }

    @GetMapping("/addrChange")
    public String addrChange() {
        return "member/addrChange";

    }


    @GetMapping("/shoppingList")
    public String shoppingList( Model model) {
        String memberEmail = (String) session.getAttribute("loginEmail");
        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);
        List<OrderDetailDTO> oList = ss.findByMemberEntity1(memberEntity);
        System.out.println(oList);
        model.addAttribute("oList", oList);

        return "member/shoppingList";
    }


    @GetMapping("/shoppingLike")
    public String shoppingLike(Model model) {
        String memberEmail = (String) session.getAttribute("loginEmail");
        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);
        List<ShoppingLikeDetailDTO> slList = sls.findByMemberEntity(memberEntity);

        List<CampingLikeDetailDTO> campingLike = cls.findByMemberEntity(memberEntity);
        System.out.println(campingLike.toString());
        model.addAttribute("campingLike", campingLike);

        System.out.println(slList);
        model.addAttribute("slList", slList);
        return "member/shoppingLike";
    }





}
