package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface ProductRepositroy extends JpaRepository<ProductEntity,Long> {



}
