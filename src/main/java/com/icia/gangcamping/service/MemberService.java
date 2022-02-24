package com.icia.gangcamping.service;


import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.MemberEntity;

import java.util.Optional;

public interface MemberService {

    MemberEntity findByMemberEmail(String memberEmail);
    Optional<MemberEntity> findByMemberId(Long memberId);

    boolean login(MemberLoginDTO memberLoginDTO);

    Long save(MemberSaveDTO memberSaveDTO);

    Long findByMemberId(String memberEmail);
    Optional<MemberEntity> findById(Long memberId);


    MemberDetailDTO findByEmail(String memberEmail);



    String pwMailCheck(String memberEmail);


    Long update(MemberUpdateDTO memberUpdateDTO);


    String emailDp(String memberEmail);
}
