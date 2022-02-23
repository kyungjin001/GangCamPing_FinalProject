package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.BookEntity;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;


import com.icia.gangcamping.entity.RoomEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

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
    private LocalDateTime createTime;
    private String bookPeriod;
    private String campingName;
    private String campingFileName;
    private int bookPrice;

    public static BookDetailDTO toBookDetailDTO(BookEntity bookEntity) {
        BookDetailDTO bookDetailDTO = new BookDetailDTO();
        bookDetailDTO.setBookId(bookEntity.getBookId());
        bookDetailDTO.setMemberId(bookEntity.getMemberEntity().getMemberId());
        bookDetailDTO.setCampingId(bookEntity.getCampingEntity().getCampingId());
        bookDetailDTO.setRoomId(bookEntity.getRoomEntity().getRoomId());
        bookDetailDTO.setBookCheckIn(bookEntity.getBookCheckIn());
        bookDetailDTO.setBookCheckOut(bookEntity.getBookCheckOut());
        bookDetailDTO.setBookPeriod(bookEntity.getBookPeriod());
        bookDetailDTO.setCreateTime(bookEntity.getCreateTime());
        return bookDetailDTO;
    }



}
