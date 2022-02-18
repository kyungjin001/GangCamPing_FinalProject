package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.MemberLoginDTO;

public interface MemberService {
    boolean login(MemberLoginDTO memberLoginDTO);
}
