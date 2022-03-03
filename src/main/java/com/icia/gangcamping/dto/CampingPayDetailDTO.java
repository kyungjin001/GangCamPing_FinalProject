package com.icia.gangcamping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampingPayDetailDTO {

    private Long campingPayId;
    private Long memberId;
    private Long campingId;
    private Long bookId;
    private int campingPayPrice;
    private String campingPaySelect;
    private LocalDateTime boardDate;
}
