package com.icia.gangcamping.service;


import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.MemberEntity;

import java.io.IOException;
import java.util.Optional;

public interface MemberService {

    MemberEntity findByMemberEmail(String memberEmail);
    Optional<MemberEntity> findByMemberId(Long memberId);

    boolean login(MemberLoginDTO memberLoginDTO);

    Long save(MemberSaveDTO memberSaveDTO);

    Long findByMemberId(String memberEmail);
    MemberDetailDTO findById(Long memberId);


    MemberDetailDTO findByEmail(String memberEmail);



    String pwMailCheck(String memberEmail);

    Long update(MemberUpdateDTO memberUpdateDTO) throws IllegalStateException, IOException;

    String emailDp(String memberEmail);

    void deleteById(Long memberId);

//    MemberDetailDTO updateAddr(MemberUpdateDTO memberUpdateDTO);


//    Long confirmPW(MemberUpdateDTO memberUpdateDTO);
}
