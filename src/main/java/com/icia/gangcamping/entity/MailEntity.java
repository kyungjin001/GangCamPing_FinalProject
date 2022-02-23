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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emailId")
    private Long Id;

    @Column
    private String emailCode;

    @Column
    private String memberEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;

    public static MailEntity saveMailCode(MailCodeDTO mailCodeDTO, MemberEntity memberEntity) {
        MailEntity mailEntity = new MailEntity();
        mailEntity.setEmailCode(mailCodeDTO.getEmailCode());
        mailEntity.setMemberEmail(mailCodeDTO.getMemberEmail());
        mailEntity.setMemberEntity(memberEntity);
        return mailEntity;
    }


}
