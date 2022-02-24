package com.icia.gangcamping.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CommentSaveDTO {


    private Long memberId;
    private Long productId;
    private String commentWriter;
    private String questionContents;
    private LocalDateTime commentTime;


}
