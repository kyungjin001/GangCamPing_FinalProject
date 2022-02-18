package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.MailCodeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="emailCode")
public class MailEntity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emailId")
    private Long Id;

    @Column
    private String emailCheck;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;

    public static MailEntity saveMailCode(MailCodeDTO mailCodeDTO) {
        MailEntity mailEntity = new MailEntity();
        mailEntity.setEmailCheck(mailCodeDTO.getEmailCode());
        return mailEntity;
    }
}
