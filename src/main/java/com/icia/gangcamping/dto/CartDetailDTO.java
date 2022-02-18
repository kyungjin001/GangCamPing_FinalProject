package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.CartEntity;
import com.icia.gangcamping.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CartDetailDTO {


    private Long productId;
    private Long cartId;
    private Long memberId;
    private int cPriceSum;
    private int cartAmount;



    public static CartDetailDTO toCartDetailDTO (CartEntity cart){
        CartDetailDTO cartDetailDTO = new CartDetailDTO();
        cartDetailDTO.setProductId(cart.getProductEntity().getProductId());
//        cartDetailDTO.setCartId(cart.getCartId());
        cartDetailDTO.setMemberId(cart.getMemberEntity().getMemberId());
        cartDetailDTO.setCPriceSum(cart.getCartPriceSum());
        cartDetailDTO.setCartAmount(cart.getCartAmount());


        return cartDetailDTO;
    }



    public static CartDetailDTO tpCartDetailDTO (CartEntity cart){
        CartDetailDTO cartDetailDTO = new CartDetailDTO();
        cartDetailDTO.setProductId(cart.getProductEntity().getProductId());
//        cartDetailDTO.setCartId(cart.getCartId());
        cartDetailDTO.setMemberId(cart.getMemberEntity().getMemberId());


        return cartDetailDTO;
    }



}
