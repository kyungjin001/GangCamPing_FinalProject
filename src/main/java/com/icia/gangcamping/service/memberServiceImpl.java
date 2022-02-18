package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class memberServiceImpl implements MemberService {
    private final MemberRepository mr;
    @Override
    public boolean login(MemberLoginDTO memberLoginDTO) {
        mr.findByMemberEmailAndMemberPw(memberLoginDTO.getMemberEmail(),memberLoginDTO.getMemberPw());
        return false;
    }
}
