package com.icia.gangcamping.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderSaveDTO {


    private Long orderId;
    private Long memberId;
    private int orderUnitNum;
    private int orderTotalFee;
    private String orderPayType;
    private LocalDateTime orderTime;




}
