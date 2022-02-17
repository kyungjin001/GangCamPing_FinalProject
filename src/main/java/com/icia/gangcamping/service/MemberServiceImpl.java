package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.dto.MemberSaveDTO;
import com.icia.gangcamping.entity.bookEntity;
import com.icia.gangcamping.entity.campingEntity;
import com.icia.gangcamping.entity.memberEntity;
import com.icia.gangcamping.entity.roomEntity;
import com.icia.gangcamping.repository.BookRepository;
import com.icia.gangcamping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository mr;
    private final BookRepository br;


    @Override
    public Long save(MemberSaveDTO memberSaveDTO) {
        memberEntity memberEntity1 = memberEntity.saveMember(memberSaveDTO);
        return mr.save(memberEntity1).getMemberId();
    }

    @Override
    public boolean login(MemberLoginDTO memberLoginDTO) {
        memberEntity memberEntity = mr.findByMemberEmail(memberLoginDTO.getMemberEmail());
        if(memberEntity != null) {
            if (memberLoginDTO.getMemberPw().equals(memberEntity.getMemberPw())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String emailDp(String memberEmail) {
        Optional<memberEntity> memberEntity = Optional.ofNullable(mr.findByMemberEmail(memberEmail));
        if (memberEntity.isEmpty()) {
            return "ok";
        } else {
            return "no";
        }
    }

    @Override
    public MemberDetailDTO findByEmail(String memberEmail) {
        return null;
    }


}
