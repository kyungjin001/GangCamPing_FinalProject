package com.icia.gangcamping.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ChattingDetailDTO {


    private Long memberId;
    private Long chattingId;
    private LocalDateTime chattingDate;
    private String chattingContents;
    private MultipartFile chattingImage;
    private String chattingFileName;







}
