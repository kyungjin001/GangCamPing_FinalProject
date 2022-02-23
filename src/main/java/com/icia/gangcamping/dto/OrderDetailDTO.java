package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderDetailDTO {


    private Long productId;
    private Long orderId;
    private Long memberId;
    private int orderUnitNum;
    private int orderTotalFee;
    private String orderPayType;



    public static OrderDetailDTO toOrderDetailDTO (Optional<OrderEntity> order){
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setMemberId(order.get().getMemberEntity().getMemberId());
//        orderDetailDTO.setProductId(order.get().getProductEntity().getProductId());
        return orderDetailDTO;
    }







}
