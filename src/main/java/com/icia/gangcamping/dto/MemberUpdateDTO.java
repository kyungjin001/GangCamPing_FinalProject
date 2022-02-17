package com.icia.gangcamping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateDTO {

    private Long memberId;
    private String memberEmail;
    private String memberPw;
    private String memberName;
    private String memberAddr;
    private String memberPhone;

}
