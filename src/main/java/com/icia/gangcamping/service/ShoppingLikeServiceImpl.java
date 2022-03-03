package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.*;
import com.icia.gangcamping.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor


public class ShoppingLikeServiceImpl implements ShoppingLikeService{

    private final ProductRepositroy pr;
    private final ShoppingLikeRepository slr;
    private final CartRepository cr;
    private final ShoppingService ss;
    private final OrderRepository or;
    private  final StockRepository tr;
    private  final  MemberService ms;


    @Override
    public ShoppingLikeDetailDTO findByMemberEntityAndProductEntity(MemberEntity memberEntity, Optional<ProductEntity> product) {
        ShoppingLikeEntity shoppingLike = slr.findByMemberEntityAndProductEntity(memberEntity, product);

        if(shoppingLike != null){
            ShoppingLikeDetailDTO shoppingLikeDetailDTO = ShoppingLikeDetailDTO.shoppingLikeDetailDTO(shoppingLike);
            return shoppingLikeDetailDTO;
        }
        return null;
    }

    @Override
    public ProductEntity findById(Long productId) {
        return pr.findById(productId).get();
    }

    @Override
    public Long save(ShoppingLikeSaveDTO shoppingLikeSaveDTO, String memberEmail) {
        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);
        ProductEntity productEntity = ss.findById2(shoppingLikeSaveDTO.getProductId());
        ShoppingLikeEntity shoppingLike = ShoppingLikeEntity.toSaveEntity(shoppingLikeSaveDTO,memberEntity,productEntity);
        System.out.println(shoppingLike);
        return slr.save(shoppingLike).getShoppingLikeId();
    }

    @Override
    public void deleteById(Long shoppingLikeId) {
        slr.deleteById(shoppingLikeId);
    }

    @Override
    public List<ShoppingLikeDetailDTO> findByMemberEntity(MemberEntity memberEntity) {
        List<ShoppingLikeDetailDTO> sList = new ArrayList<>();
        List<ShoppingLikeEntity> shop = slr.findByMemberEntity(memberEntity);
        for(ShoppingLikeEntity shoppingLike : shop) {
            sList.add(ShoppingLikeDetailDTO.shoppingLikeDetailDTO(shoppingLike));
        }
        return sList;
    }


}
