package com.icia.gangcamping.service;


import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.dto.MemberSaveDTO;

import java.util.List;

public interface MemberService {
    Long save(MemberSaveDTO memberSaveDTO);

    boolean login(MemberLoginDTO memberLoginDTO);

    boolean emailCheck(String memberEmail);

    BookDetailDTO findById(Long memberId);


    List<BookDetailDTO> bookList();
}
