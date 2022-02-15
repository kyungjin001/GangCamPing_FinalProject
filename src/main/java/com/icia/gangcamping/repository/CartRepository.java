package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity,Long> {
}
