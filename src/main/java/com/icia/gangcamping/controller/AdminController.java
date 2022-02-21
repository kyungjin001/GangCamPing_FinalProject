package com.icia.gangcamping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/*")
public class AdminController {

    @RequestMapping("mypage")
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
    public String bookList() {
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
