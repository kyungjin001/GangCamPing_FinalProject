package com.icia.gangcamping.service;


import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.dto.MemberSaveDTO;

import java.util.List;

public interface MemberService {
    Long save(MemberSaveDTO memberSaveDTO);

    boolean login(MemberLoginDTO memberLoginDTO);

    String emailDp(String memberEmail);


    MemberDetailDTO findByEmail(String memberEmail);
}
