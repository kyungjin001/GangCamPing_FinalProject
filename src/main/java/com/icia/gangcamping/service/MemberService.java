package com.icia.gangcamping.service;

import com.icia.gangcamping.entity.MemberEntity;

import java.util.Optional;

public interface MemberService {
    Optional<MemberEntity> findById(Long memberId);


    MemberEntity findByMemberEmail(String memberEmail);
}
