package com.icia.gangcamping.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderSaveDTO {


    private Long productId;
    private Long orderId;
    private Long memberId;
    private int orderUnitNum;
    private int orderTotalFee;
    private String orderPayType;



}
