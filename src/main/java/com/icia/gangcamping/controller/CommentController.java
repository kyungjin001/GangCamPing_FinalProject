package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.ReviewSaveDTO;
import com.icia.gangcamping.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final ReviewService rs;
    @PostMapping("/campingReviewSave")
    public String CampingReviewSave(@ModelAttribute ReviewSaveDTO reviewSaveDTO, Model model){
        rs.save(reviewSaveDTO);
        return "redirect:/mypage/bookList";
    }
}
