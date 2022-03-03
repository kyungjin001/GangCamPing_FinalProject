package com.icia.gangcamping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampingPaySaveDTO {

    private Long memberId;
    private Long campingId;
    private Long bookId;
    private int campingPayPrice;
    private String campingPaySelect;
}
