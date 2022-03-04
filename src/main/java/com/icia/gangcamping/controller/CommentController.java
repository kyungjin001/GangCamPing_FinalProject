package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.CommentDetailDTO;
import com.icia.gangcamping.dto.CommentSaveDTO;
import com.icia.gangcamping.dto.GoodsDetailDTO;
import com.icia.gangcamping.service.CommentService;
import com.icia.gangcamping.dto.ReviewSaveDTO;
import com.icia.gangcamping.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor //의존성주입
public class CommentController {
    private final CommentService cs;
      private final ReviewService rs;

    @PostMapping("/save")
    public @ResponseBody List<CommentDetailDTO> save(@ModelAttribute CommentSaveDTO commentSaveDTO) throws ParseException {
        Long commentId = cs.save(commentSaveDTO);
        List<CommentDetailDTO> commentList = cs.findAll(commentSaveDTO.getProductId());
        return commentList;
    }

    //댓글삭제
    @DeleteMapping("{questionId}")
    public ResponseEntity deleteById(@PathVariable Long questionId) {
        cs.deleteById(questionId);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/campingReviewSave")
    public String CampingReviewSave(@ModelAttribute ReviewSaveDTO reviewSaveDTO, Model model){
        rs.save(reviewSaveDTO);
        return "redirect:/mypage/bookList";
    }


    @GetMapping("/shoppingAsk")
    public String findAll(Model model) {
        List<CommentDetailDTO> cList = cs.findAll1();
        System.out.println(cList);
        model.addAttribute("cList", cList);
        return "redirect:/admin/shoppingAsk";

    }
}





