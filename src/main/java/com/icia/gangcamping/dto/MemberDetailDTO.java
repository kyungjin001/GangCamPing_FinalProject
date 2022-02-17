package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.memberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDetailDTO {

    private Long memberId;
    private String memberEmail;
    private String memberPw;
    private String memberName;
    private String memberAddr;
    private String memberPhone;

    public static MemberDetailDTO toMemberDetailDTO(memberEntity memberEntity) {
        MemberDetailDTO memberDetailDTO = new MemberDetailDTO();
        memberDetailDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDetailDTO.setMemberPw(memberEntity.getMemberPw());
        memberDetailDTO.setMemberName(memberEntity.getMemberName());
        memberDetailDTO.setMemberAddr(memberEntity.getMemberAddr());
        memberDetailDTO.setMemberPhone(memberEntity.getMemberPhone());
        return memberDetailDTO;
    }

}
