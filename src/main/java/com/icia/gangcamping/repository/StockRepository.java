package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.ShoppingLikeEntity;
import com.icia.gangcamping.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity,Long> {
}
