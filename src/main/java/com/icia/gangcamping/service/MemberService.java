package com.icia.gangcamping.service;

import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.dto.MemberLoginDTO;

import java.util.Optional;

public interface MemberService {
    Optional<MemberEntity> findById(Long memberId);
    boolean login(MemberLoginDTO memberLoginDTO);


    MemberEntity findByMemberEmail(String memberEmail);}

