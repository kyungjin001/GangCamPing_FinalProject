package com.icia.gangcamping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginDTO {

    @NotBlank(message = "이메일은 필수입니다.")
    @Length(min = 2, max = 30, message = "3~50자 사이로 입력해주세요.")
    private String memberEmail;
    @Length(min = 2, max = 20, message = "5~20자 사이로 입력해주세요.")
    private String memberPw;


}