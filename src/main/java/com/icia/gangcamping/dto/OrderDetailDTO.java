package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderDetailDTO {


    private Long orderId;
    private Long memberId;
    private int orderUnitNum;
    private int orderTotalFee;
    private String orderPayType;
    private LocalDateTime orderTime;




    public static OrderDetailDTO toOrderDetailDTO (Optional<OrderEntity> order){
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setMemberId(order.get().getMemberEntity().getMemberId());
        orderDetailDTO.setOrderId(order.get().getOrderId());
        orderDetailDTO.setOrderUnitNum(order.get().getOrderUnitNum());
        orderDetailDTO.setOrderTotalFee(order.get().getOrderTotalFee());
        orderDetailDTO.setOrderPayType("카카오페이");
        orderDetailDTO.setOrderTime(order.get().getCreateTime());
        return orderDetailDTO;
    }







}
