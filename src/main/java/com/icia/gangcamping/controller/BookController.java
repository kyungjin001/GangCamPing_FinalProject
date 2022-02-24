package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.BookSaveDTO;
import com.icia.gangcamping.dto.CampingDetailDTO;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.service.BookService;
import com.icia.gangcamping.service.CampingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookController {
    private final CampingService cs;
    private final BookService bs;

    // 예약저장
    @PostMapping("/reservation")
    public String reservation(HttpSession session, @ModelAttribute BookSaveDTO bookSaveDTO){
        System.out.println("asdfsdfasdf");
        String period = (String)session.getAttribute("period")+"박 "+(String)session.getAttribute("period2")+"일";
        System.out.println(period);
        bookSaveDTO.setBookPeriod(period);
       Long bookId = bs.save(bookSaveDTO);

        return "/camping/campingPay";
    }

    //별점순으로 정렬 100개
    @GetMapping("/ranking")
    public String ranking(Model model){
        List<CampingEntity>  entityList= cs.findAll();
        List searchList = new ArrayList();
        int i=0;
        while (i<100){
            searchList.add(CampingDetailDTO.toCampingDetailDTO(entityList.get(i)));
            i++;
        }
        model.addAttribute("searchList",searchList);
        return "ranking";
    }

    @GetMapping("/bookDetail/{bookId}")
    public String bookDetail(@PathVariable Long bookId,Model model){
        BookDetailDTO book = bs.findById(bookId);
        Optional<CampingEntity> camping = cs.findById(book.getCampingId());
        book.setCampingName(camping.get().getCampingName());
        if(camping.get().getCampingFileName()==null){
            book.setCampingFileName("/images/noImage.jpg");
        }else {
            book.setCampingFileName(camping.get().getCampingFileName());
        }
        model.addAttribute("book",book);

        return "member/bookDetail";
    }
}
