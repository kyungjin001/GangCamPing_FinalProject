package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<MailEntity, Long> {

    MailEntity findByEmailCode(String emailCode);

    MailEntity findByMemberEmailAndEmailCode(String memberEmail, String emailCode);
}
