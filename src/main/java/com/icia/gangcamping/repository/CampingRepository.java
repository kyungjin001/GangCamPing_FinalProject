package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.CampingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampingRepository extends JpaRepository<CampingEntity,Long> {
}
