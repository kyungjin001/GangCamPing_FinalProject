package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Long> {
}
