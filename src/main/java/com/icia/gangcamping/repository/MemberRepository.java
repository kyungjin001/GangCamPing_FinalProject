package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.bookEntity;
import com.icia.gangcamping.entity.memberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<memberEntity, Long> {
    memberEntity findByMemberEmail(String memberEmail);

}
