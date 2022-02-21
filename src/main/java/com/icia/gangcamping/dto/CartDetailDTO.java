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
    private int cartPriceSum;
    private int cartAmount;
    private String productName;
    private int productPrice;
    private int productWeight;
    private String productDescription;
    private MultipartFile productImage;
    private String productFileName;



    public static CartDetailDTO toCartDetailDTO (CartEntity cart){
        CartDetailDTO cartDetailDTO = new CartDetailDTO();
        cartDetailDTO.setProductId(cart.getProductEntity().getProductId());
        cartDetailDTO.setCartId(cart.getCartId());
        cartDetailDTO.setMemberId(cart.getMemberEntity().getMemberId());
        cartDetailDTO.setCartPriceSum(cart.getCartPriceSum());
        cartDetailDTO.setCartAmount(cart.getCartAmount());
        cartDetailDTO.setProductName(cart.getProductEntity().getProductName());
        cartDetailDTO.setProductPrice(cart.getProductEntity().getProductPrice());
        cartDetailDTO.setProductWeight(cart.getProductEntity().getProductWeight());
        cartDetailDTO.setProductDescription(cart.getProductEntity().getProductDescription());
        cartDetailDTO.setProductFileName(cart.getProductEntity().getProductFileName());


        return cartDetailDTO;
    }



    public static CartDetailDTO tpCartDetailDTO (CartEntity cart){
        CartDetailDTO cartDetailDTO = new CartDetailDTO();
        cartDetailDTO.setProductId(cart.getProductEntity().getProductId());
        cartDetailDTO.setCartId(cart.getCartId());
        cartDetailDTO.setMemberId(cart.getMemberEntity().getMemberId());
        cartDetailDTO.setCartPriceSum(cart.getCartPriceSum());
        cartDetailDTO.setCartAmount(cart.getCartAmount());
        cartDetailDTO.setProductName(cart.getProductEntity().getProductName());
        cartDetailDTO.setProductPrice(cart.getProductEntity().getProductPrice());
        cartDetailDTO.setProductWeight(cart.getProductEntity().getProductWeight());
        cartDetailDTO.setProductDescription(cart.getProductEntity().getProductDescription());
        cartDetailDTO.setProductFileName(cart.getProductEntity().getProductFileName());

        return cartDetailDTO;
    }



}
