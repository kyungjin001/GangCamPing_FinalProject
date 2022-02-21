package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.MailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailCodeDetailDTO {

    private Long emailId;
    private Long memberId;
    private String memberEmail;
    private String emailCode;

    public static MailCodeDetailDTO toMailCodeDetailDTO(MailEntity mailEntity) {

        MailCodeDetailDTO mailCodeDetailDTO = new MailCodeDetailDTO();
        mailCodeDetailDTO.setMemberEmail(mailEntity.getMemberEmail());
        mailCodeDetailDTO.setEmailCode(mailEntity.getEmailCode());
        mailCodeDetailDTO.setMemberId(mailEntity.getMemberEntity().getMemberId());
        return mailCodeDetailDTO;
    }
}
