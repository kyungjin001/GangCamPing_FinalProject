package com.icia.gangcamping.service;

import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository mr;
    @Override
    public Optional<MemberEntity> findById(Long memberId) {

        return mr.findById(memberId);
    }

    @Override
    public MemberEntity findByMemberEmail(String memberEmail) {
        return mr.findByMemberEmail(memberEmail);
    }


}
