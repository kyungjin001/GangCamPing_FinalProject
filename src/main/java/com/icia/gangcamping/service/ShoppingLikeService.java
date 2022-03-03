package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ShoppingLikeService {



    ShoppingLikeDetailDTO findByMemberEntityAndProductEntity(MemberEntity memberEntity, Optional<ProductEntity> product);


    ProductEntity findById(Long productId);

    Long save(ShoppingLikeSaveDTO shoppingLikeSaveDTO, String memberEmail);

    void deleteById(Long shoppingLikeId);

    List<ShoppingLikeDetailDTO> findByMemberEntity(MemberEntity memberEntity);
}
