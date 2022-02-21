package com.icia.gangcamping.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CartSaveDTO {


    private Long productId;
    private Long memberId;
    private int cartPriceSum;
    private int cartAmount;



}
