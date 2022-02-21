package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.dto.MemberSaveDTO;

import java.io.IOException;

public interface memberService {
    Long save(MemberSaveDTO memberSaveDTO) throws IllegalStateException, IOException;

    boolean login(MemberLoginDTO memberLoginDTO);

    String emailDp(String memberEmail);

    MemberDetailDTO findByEmail(String memberEmail);

    MemberDetailDTO findById(Long memberId);

}
