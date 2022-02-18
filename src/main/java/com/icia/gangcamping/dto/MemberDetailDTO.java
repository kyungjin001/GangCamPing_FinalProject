package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDetailDTO {

    private Long memberId;
    private String memberEmail;
    private String memberPW;
    private String memberName;
    private String memberAddr;
    private String memberPhone;

    public static MemberDetailDTO toMemberDetailDTO(MemberEntity memberEntity) {
        MemberDetailDTO memberDetailDTO = new MemberDetailDTO();

        memberDetailDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDetailDTO.setMemberPW(memberEntity.getMemberPw());
        memberDetailDTO.setMemberName(memberEntity.getMemberName());
        memberDetailDTO.setMemberAddr(memberEntity.getMemberAddr());
        memberDetailDTO.setMemberPhone(memberEntity.getMemberPhone());
        return memberDetailDTO;
    }
}
