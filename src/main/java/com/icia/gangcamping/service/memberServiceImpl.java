package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.BookDetailDTO;
import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.dto.MemberSaveDTO;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.repository.BookRepository;
import com.icia.gangcamping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class memberServiceImpl implements memberService {

    private final MemberRepository mr;


    @Override
    public Long save(MemberSaveDTO memberSaveDTO) {
        MemberEntity memberEntity = MemberEntity.saveMember(memberSaveDTO);
        return mr.save(memberEntity).getMemberId();
    }

    @Override
    public boolean login(MemberLoginDTO memberLoginDTO) {
        MemberEntity memberEntity = mr.findByMemberEmail(memberLoginDTO.getMemberEmail());
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
        Optional<MemberEntity> memberEntity = Optional.ofNullable(mr.findByMemberEmail(memberEmail));
        if (memberEntity.isEmpty()) {
            return "ok";
        } else {
            return "no";
        }
    }

    @Override
    public MemberDetailDTO findByEmail(String memberEmail) {
        MemberEntity memberEntity = mr.findByMemberEmail(memberEmail);
        MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(memberEntity);
        return memberDetailDTO;
    }

    @Override
    public MemberDetailDTO findById(Long memberId) {
        Optional<MemberEntity>  memeberEntity = mr.findById(memberId);
        MemberEntity memberEntity = memeberEntity.get();
        MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(memberEntity);
        return memberDetailDTO;
    }


}

