package com.icia.gangcamping.dto;

import lombok.Data;

@Data
public class MemberUpdateDTO {

    private String memberEmail;
    private String memberPW;
    private String memberName;
    private String memberAddr;
    private String memberPhone;
}
