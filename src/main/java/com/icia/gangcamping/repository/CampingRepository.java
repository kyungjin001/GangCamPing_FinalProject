package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.CampingDetailEntity;
import com.icia.gangcamping.entity.CampingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampingRepository extends JpaRepository<CampingEntity,Long> {
    CampingEntity findByCampingName(String campingName);


    List<CampingEntity> findTop4ByOrderByCampingLikeCountDesc();

}
