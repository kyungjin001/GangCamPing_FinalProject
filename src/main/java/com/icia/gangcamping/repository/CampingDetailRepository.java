package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.CampingDetailEntity;
import com.icia.gangcamping.entity.CampingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampingDetailRepository extends JpaRepository<CampingDetailEntity,Long> {


    CampingDetailEntity findByCampingEntity(CampingEntity campingEntity);
}
