package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.repository.BookRepository;
import com.icia.gangcamping.repository.CampingRepository;
import com.icia.gangcamping.repository.MemberRepository;
import com.icia.gangcamping.service.BookService;
import com.icia.gangcamping.service.CampingService;
import com.icia.gangcamping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/*")
public class AdminController {

    private final BookService bs;
    private final BookRepository br;
    private  final MemberService ms;
    private final MemberRepository mr;
    private final CampingService cs;
    private final CampingRepository cr;
    @RequestMapping("admin")
    public String mypage() {
        return "admin/mypage";

    }

    @RequestMapping("chatList")
    public String chatList() {
        return "admin/chatList";

    }

    @RequestMapping("memberList")
    public String memberList() {
        return "admin/memberList";

    }

    @RequestMapping("memberDetail")
    public String memberDetail() {
        return "admin/memberDetail";

    }

    @RequestMapping("bookList")
    public String bookList(Model model) {
        List<BookDetailDTO> bookList = bs.findAll();
        model.addAttribute("bookList",bookList);
        return "admin/bookList";

    }
    @RequestMapping("findAll")
    public String findAll() {
        return "admin/findAll";

    }

    @RequestMapping("campingSaleList")
    public String campingSaleList() {
        return "admin/campingSaleList";

    }


    @RequestMapping("salesGraph")
    public String salesGraph() {
        return "admin/campingSaleList";

    }

    @RequestMapping("productSaleList")
    public String productSaleList() {
        return "admin/productSaleList";

    }


    @RequestMapping("save")
    public String saveForm() {
        return "admin/save";

    }
    @RequestMapping("stock")
    public String stock() {
        return "admin/stock";

    }

    @RequestMapping("shoppingAsk")
    public String shoppingAsk() {
        return "admin/shoppingAsk";

    }


}
