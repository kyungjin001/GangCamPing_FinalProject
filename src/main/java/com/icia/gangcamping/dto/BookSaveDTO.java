package com.icia.gangcamping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveDTO {

    private Long memberId;
    private Long campingId;
    private String campingName;
    private int bookPrice;
    private Date bookCheckIn;
    private Date bookCheckOut;
    private String bookName;
}
