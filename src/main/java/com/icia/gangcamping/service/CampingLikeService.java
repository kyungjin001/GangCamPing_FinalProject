package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CampingLikeDTO;
import com.icia.gangcamping.dto.CampingLikeDetailDTO;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;

import java.util.Optional;

public interface CampingLikeService {
    Long save(CampingLikeDTO campingLikeDTO, String memberEmail);


    CampingLikeDetailDTO findMemberEntityAndCampingEntity(MemberEntity memberEntity, Optional<CampingEntity> camping);
}
