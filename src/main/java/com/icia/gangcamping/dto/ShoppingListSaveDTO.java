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
public class ShoppingListSaveDTO {



    private Long orderId;
    private Long memberId;
    private Long shoppingListId;
    private int orderUnitNum;
    private int shoppingListPrice;
    private String orderPayType;
    private String productName;
    private String productDescription;
    private LocalDateTime shoppingListDate;











}
