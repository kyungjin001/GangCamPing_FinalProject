package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.BookSaveDTO;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;

import java.util.List;

public interface BookService {
    List<BookDetailDTO> findByMemberEntity(MemberEntity memberEntity);

    BookDetailDTO findById(Long bookId);

    Long save(BookSaveDTO bookSaveDTO, String memberEmail);

    List<BookDetailDTO> findAll();

    void deleteById(Long bookId);

}
