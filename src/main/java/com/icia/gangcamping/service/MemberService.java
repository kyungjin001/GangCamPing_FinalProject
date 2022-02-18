package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.dto.MemberSaveDTO;

public interface MemberService {

    Long save(MemberSaveDTO memberSaveDTO);

    boolean login(MemberLoginDTO memberLoginDTO);

    Long findByMemberId(String memberEmail);

    MemberDetailDTO findByEmail(String memberEmail);

    MemberDetailDTO findById(Long memberId);

    String pwMailCheck(String memberEmail);
}
