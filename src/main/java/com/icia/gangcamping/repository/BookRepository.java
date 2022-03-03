package com.icia.gangcamping.repository;


import com.icia.gangcamping.entity.BookEntity;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByMemberEntity(MemberEntity memberEntity);

}
