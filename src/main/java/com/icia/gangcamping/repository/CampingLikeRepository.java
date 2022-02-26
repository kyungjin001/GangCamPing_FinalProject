package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.CampingLikeEntity;
import com.icia.gangcamping.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CampingLikeRepository extends JpaRepository<CampingLikeEntity,Long> {

    CampingLikeEntity findMemberEntityAndCampingEntity(MemberEntity memberEntity, Optional<CampingEntity> camping);
}
