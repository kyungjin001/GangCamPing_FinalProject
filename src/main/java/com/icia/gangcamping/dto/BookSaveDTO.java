package com.icia.gangcamping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveDTO {

    private Long memberId;
    private Long campingId;
    private String bookPrice;
}
