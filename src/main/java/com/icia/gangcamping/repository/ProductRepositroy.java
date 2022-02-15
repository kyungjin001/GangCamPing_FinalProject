package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositroy extends JpaRepository<ProductEntity,Long> {
}
