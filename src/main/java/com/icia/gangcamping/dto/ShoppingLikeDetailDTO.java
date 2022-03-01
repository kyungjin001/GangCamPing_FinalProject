package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.ShoppingLikeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ShoppingLikeDetailDTO {


    private Long shoppingLikeId;
    private Long memberId;
    private Long productId;
    private String productName;
    private String productDescription;



    public static ShoppingLikeDetailDTO shoppingLikeDetailDTO(ShoppingLikeEntity shoppingLike) {
        ShoppingLikeDetailDTO shoppingLikeDetailDTO = new ShoppingLikeDetailDTO();
        shoppingLikeDetailDTO.setShoppingLikeId(shoppingLike.getShoppingLikeId());
        shoppingLikeDetailDTO.setProductName(shoppingLike.getProductEntity().getProductName());
        shoppingLikeDetailDTO.setProductName(shoppingLike.getProductEntity().getProductDescription());
        shoppingLikeDetailDTO.setMemberId(shoppingLike.getMemberEntity().getMemberId());
        shoppingLikeDetailDTO.setProductId(shoppingLike.getProductEntity().getProductId());
        return shoppingLikeDetailDTO;
    }








}
