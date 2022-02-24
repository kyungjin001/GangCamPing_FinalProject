package com.icia.gangcamping.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StockSaveDTO {



    private Long stockId;
    private Long productId;
    private int Stock;



}
