package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CampingLikeDTO;
import com.icia.gangcamping.dto.CampingLikeDetailDTO;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface CampingLikeService {
    Long save(CampingLikeDTO campingLikeDTO, String memberEmail);

    CampingLikeDetailDTO findByMemberEntityAndCampingEntity(MemberEntity memberEntity, Optional<CampingEntity> camping);


    void deleteById(Long campingLikeId);

    List<CampingLikeDetailDTO> findByMemberEntity(MemberEntity memberEntity);
}
