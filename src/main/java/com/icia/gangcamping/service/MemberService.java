package com.icia.gangcamping.service;

import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.dto.MemberLoginDTO;

import java.util.Optional;

public interface MemberService {
    Optional<MemberEntity> findById(Long memberId);
    boolean login(MemberLoginDTO memberLoginDTO);


    MemberEntity findByMemberEmail(String memberEmail);}

import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.dto.MemberSaveDTO;
import com.icia.gangcamping.dto.MemberUpdateDTO;

public interface MemberService {

    Long save(MemberSaveDTO memberSaveDTO);

    boolean login(MemberLoginDTO memberLoginDTO);

    Long findByMemberId(String memberEmail);

    MemberDetailDTO findByEmail(String memberEmail);

    MemberDetailDTO findById(Long memberId);

    String pwMailCheck(String memberEmail);


    Long update(MemberUpdateDTO memberUpdateDTO);
}
