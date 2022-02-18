package com.icia.gangcamping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberSaveDTO {

    private String memberEmail;
    private String memberPW;
    private String memberName;
    private String memberAddr;
    private String memberPhone;
}
