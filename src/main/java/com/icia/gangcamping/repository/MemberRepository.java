package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    MemberEntity findByMemberEmail(String memberEmail);

    boolean findByMemberEmailAndMemberPw(String memberEmail,String memberPw);
}


