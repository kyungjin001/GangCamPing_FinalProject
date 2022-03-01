package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.OrderEntity;
import com.icia.gangcamping.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    List<OrderEntity> findByMemberEntity(MemberEntity memberEntity);
}
