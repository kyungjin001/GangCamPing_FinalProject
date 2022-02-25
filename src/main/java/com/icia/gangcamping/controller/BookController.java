package com.icia.gangcamping.controller;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.BookSaveDTO;
import com.icia.gangcamping.dto.CampingDetailDTO;
import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.entity.BookEntity;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.repository.CampingRepository;
import com.icia.gangcamping.repository.MemberRepository;
import com.icia.gangcamping.service.BookService;
import com.icia.gangcamping.service.CampingService;
import com.icia.gangcamping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
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
    private final MemberService ms;


    // 예약저장
    @PostMapping("/reservation")
    public String reservation(Model model, @ModelAttribute BookSaveDTO bookSaveDTO, HttpSession session) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date checkInDate = format.parse((String) session.getAttribute("checkInDate"));
        Date checkOutDate = format.parse((String) session.getAttribute("checkOutDate"));

        String memberEmail = (String)session.getAttribute("loginEmail");

        bookSaveDTO.setBookCheckIn(checkInDate);
        bookSaveDTO.setBookCheckOut(checkOutDate);

        Long bookId = bs.save(bookSaveDTO, memberEmail);
        MemberDetailDTO member = MemberDetailDTO.toMemberDetailDTO(ms.findByMemberEmail(memberEmail));
        BookDetailDTO bookDetail = bs.findById(bookId);
        Optional<CampingEntity> camping = cr.findById(bookDetail.getCampingId());
        bookDetail.setCampingName(camping.get().getCampingName());

        long period = (checkOutDate.getTime()-checkInDate.getTime()) / 1000;
        long period1 = period/(24*60*60); // 몇 박
        long period2 = (period/(24*60*60))+1; // 몇 일

        model.addAttribute("member", member);
        model.addAttribute("book", bookDetail);
        model.addAttribute("period1",period1);
        model.addAttribute("period2",period2);

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
