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
    @Length(min = 5, max = 30, message = "회원가입 시 이메일을 적어주세요")
    private String memberEmail;
    @Length(min = 8, max = 20, message = "8~20자 사이로 입력해주세요.")
    private String memberPw;

}