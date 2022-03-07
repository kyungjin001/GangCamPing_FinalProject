package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.BookSaveDTO;
import com.icia.gangcamping.entity.BookEntity;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.repository.BookRepository;
import com.icia.gangcamping.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository br;
    private final MemberService ms;
    private final CampingService cs;

    @Override
    public List<BookDetailDTO> findByMemberEntity(MemberEntity memberEntity) {
        List<BookEntity> list = br.findByMemberEntity(memberEntity);
        List<BookDetailDTO> bList = new ArrayList<>();

        for (BookEntity entity : list) {

            BookDetailDTO dto = BookDetailDTO.toBookDetailDTO(entity);
            bList.add(dto);
        }
        return bList;
    }

    @Override
    public BookDetailDTO findById(Long bookId) {
        Optional<BookEntity> entity = br.findById(bookId);
        BookDetailDTO book = BookDetailDTO.toBookDetailDTO(entity.get());

        return book;
    }

    @Override

    public Long save(BookSaveDTO bookSaveDTO, String memberEmail) {

        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);
        CampingEntity campingEntity = cs.findById(bookSaveDTO.getCampingId()).get();

        BookEntity bookEntity = BookEntity.toBookSave(bookSaveDTO, memberEntity, campingEntity);
        return br.save(bookEntity).getBookId();
    }


    @Override
    public List<BookDetailDTO> findAll() {
        List<BookEntity> all = br.findAll();
        List<BookDetailDTO> bookList = new ArrayList<>();
        for(BookEntity book:all){
            BookDetailDTO bookDetailDTO = BookDetailDTO.toBookDetailDTO(book);
            bookList.add(bookDetailDTO);
        }
        return bookList;


    }

    @Override
    public void deleteById(Long bookId) {
        br.deleteById(bookId);
    }
}
