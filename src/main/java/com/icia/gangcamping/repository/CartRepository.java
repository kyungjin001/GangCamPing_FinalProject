package com.icia.gangcamping.repository;

import com.icia.gangcamping.dto.CartDetailDTO;
import com.icia.gangcamping.entity.CartEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity,Long> {



    List<CartEntity> findByMemberEntity(MemberEntity memberId);
    CartEntity findByMemberEntityAndProductEntity(MemberEntity memberId, ProductEntity productId);



}
