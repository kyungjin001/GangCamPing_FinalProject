package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ShoppingService{



    Long save(GoodsSaveDTO goodsSaveDTO) throws IOException;

    List<GoodsDetailDTO> findAll();


    GoodsDetailDTO findById(Long productId);




    CartDetailDTO addCart(CartDetailDTO cartDetailDTO, MemberEntity memberEntity, ProductEntity productEntity);

    Optional<ProductEntity> findById1(Long productId);


    List<CartDetailDTO> findByMemberEntity(MemberEntity memberEntity);

    void deleteById(Long cartId);

    CartDetailDTO findByMemberEntityAndProductEntity(MemberEntity memberEntity, ProductEntity productEntity);

    String meunUpDown(Long cartId, String type);

    Long update(ShoppingUpdateDTO shoppingUpdateDTO) throws IOException;

    List<OrderDetailDTO> findByMemberEntity1(MemberEntity memberEntity);

    ProductEntity findById2(Long productId);
}
