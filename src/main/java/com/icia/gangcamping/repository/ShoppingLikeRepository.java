package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;
import com.icia.gangcamping.entity.ShoppingLikeEntity;
import com.icia.gangcamping.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingLikeRepository extends JpaRepository<ShoppingLikeEntity,Long> {
    ShoppingLikeEntity findByMemberEntityAndProductEntity(MemberEntity memberEntity, Optional<ProductEntity> product);

    List<ShoppingLikeEntity> findByMemberEntity(MemberEntity memberEntity);
}
