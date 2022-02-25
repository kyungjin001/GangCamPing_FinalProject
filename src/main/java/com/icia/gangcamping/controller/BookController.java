package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.BookSaveDTO;
import com.icia.gangcamping.dto.CampingDetailDTO;
import com.icia.gangcamping.entity.BookEntity;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.repository.CampingRepository;
import com.icia.gangcamping.repository.MemberRepository;
import com.icia.gangcamping.service.BookService;
import com.icia.gangcamping.service.CampingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookController {
    private final CampingService cs;
    private final BookService bs;
    private final CampingRepository cr;
    private final MemberRepository mr;


    // 예약저장
    @PostMapping("/reservation")
    public String reservation(BookDetailDTO bookDetailDTO, @ModelAttribute BookSaveDTO bookSaveDTO, HttpSession session) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date checkInDate = format.parse((String) session.getAttribute("checkInDate"));
        Date checkOutDate = format.parse((String) session.getAttribute("checkOutDate"));

        String memberEmail = (String)session.getAttribute("loginEmail");

        bookSaveDTO.setBookCheckIn(checkInDate);
        bookSaveDTO.setBookCheckOut(checkOutDate);
        Long bookId = bs.save(bookSaveDTO, memberEmail);


        return "/camping/campingPay";
    }

    //별점순으로 정렬 100개
    @GetMapping("/ranking")
    public String ranking(Model model){
        List<CampingEntity>  entityList= cr.findAll();
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
        Optional<CampingEntity> camping = cr.findById(book.getCampingId());
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
