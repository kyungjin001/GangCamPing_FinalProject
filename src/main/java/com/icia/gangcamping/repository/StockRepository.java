package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.ProductEntity;
import com.icia.gangcamping.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<StockEntity,Long> {
    StockEntity findByProductEntity(ProductEntity productEntity);
}
