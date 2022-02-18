package com.icia.gangcamping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginDTO {

    private String memberEmail;
    private String memberPW;
}
