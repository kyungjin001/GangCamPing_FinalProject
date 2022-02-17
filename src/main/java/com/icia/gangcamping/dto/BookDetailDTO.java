package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.bookEntity;
import com.icia.gangcamping.entity.campingEntity;
import com.icia.gangcamping.entity.memberEntity;
import com.icia.gangcamping.entity.roomEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailDTO {

    private Long bookId;
    private Long memberId;
    private Long campingId;
    private Long roomId;
    private LocalDateTime bookCheckIn;
    private LocalDateTime bookCheckOut;
    private String bookPeriod;
    private int bookPrice;

    public static BookDetailDTO toBookDetailDTO(bookEntity bookEntity, memberEntity memberEntity, campingEntity campingEntity, roomEntity roomEntity) {
        BookDetailDTO bookDetailDTO = new BookDetailDTO();
        bookDetailDTO.setBookId(bookEntity.getBookId());
        bookDetailDTO.setMemberId(memberEntity.getMemberId());
        bookDetailDTO.setCampingId(campingEntity.getCampingId());
        bookDetailDTO.setRoomId(roomEntity.getRoomId());
        bookDetailDTO.setBookCheckIn(bookEntity.getBookCheckIn());
        bookDetailDTO.setBookCheckOut(bookEntity.getBookCheckOut());
        bookDetailDTO.setBookPeriod(bookEntity.getBookPeriod());
        return bookDetailDTO;
    }


}
