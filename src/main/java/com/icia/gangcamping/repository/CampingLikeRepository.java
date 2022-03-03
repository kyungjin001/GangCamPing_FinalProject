package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.CampingLikeEntity;
import com.icia.gangcamping.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CampingLikeRepository extends JpaRepository<CampingLikeEntity,Long> {

    CampingLikeEntity findByMemberEntityAndCampingEntity(MemberEntity memberEntity, Optional<CampingEntity> camping);

    List<CampingLikeEntity> findByMemberEntity(MemberEntity memberEntity);
}
