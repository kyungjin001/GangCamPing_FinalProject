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
public class ShoppingListDetailDTO {



    private Long orderId;
    private Long memberId;
    private Long shoppingListId;
    private int shoppingListPrice;
    private String productName;
    private int orderUnitNum;
    private LocalDateTime shoppingListDate;




    public static ShoppingListDetailDTO toShopDetailDTO (OrderEntity orderEntity){
        ShoppingListDetailDTO shoppingListDetailDTO = new ShoppingListDetailDTO();
        shoppingListDetailDTO.setOrderId(orderEntity.getOrderId());
        shoppingListDetailDTO.setMemberId(orderEntity.getMemberEntity().getMemberId());
        shoppingListDetailDTO.setShoppingListPrice(orderEntity.getOrderTotalFee());
        shoppingListDetailDTO.setOrderUnitNum(orderEntity.getOrderUnitNum());
        shoppingListDetailDTO.setShoppingListDate(orderEntity.getCreateTime());
        return shoppingListDetailDTO;
    }







}
