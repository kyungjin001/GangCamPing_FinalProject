package com.icia.gangcamping.repository;

import com.icia.gangcamping.dto.MemberLoginDTO;
import com.icia.gangcamping.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    boolean findByMemberEmailAndMemberPw(String memberEmail,String memberPw);
}
