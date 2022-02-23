package com.icia.gangcamping.service;


import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.dto.MemberSaveDTO;
import com.icia.gangcamping.dto.MemberUpdateDTO;
import com.icia.gangcamping.entity.MemberEntity;

import java.util.Optional;

public interface MemberService {

    MemberEntity findByMemberEmail(String memberEmail);
    Optional<MemberEntity> findByMemberId(Long memberId);

    boolean login(MemberLoginDTO memberLoginDTO);

    Long save(MemberSaveDTO memberSaveDTO);

    Long findByMemberId(String memberEmail);

    MemberDetailDTO findByEmail(String memberEmail);


    MemberDetailDTO findById(Long memberId);

    String pwMailCheck(String memberEmail);


    Long update(MemberUpdateDTO memberUpdateDTO);

    String emailDp(String memberEmail);


    Long updateAddr(MemberUpdateAddrDTO memberUpdateAddrDTO);
}
