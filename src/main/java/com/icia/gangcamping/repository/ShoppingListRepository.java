package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.ShoppingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingListEntity,Long> {
}
