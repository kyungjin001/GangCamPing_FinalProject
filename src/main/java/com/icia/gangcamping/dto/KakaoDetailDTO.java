package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.KakaoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KakaoDetailDTO {
    private Long kakaId;
    private String kakaName;
    private String kakaEmail;

    public static KakaoDetailDTO toKakaoDetailDTO(KakaoEntity k) {
        KakaoDetailDTO kakaoDetailDTO = new KakaoDetailDTO();
        kakaoDetailDTO.setKakaId(k.getId());
        kakaoDetailDTO.setKakaEmail(k.getKakaEmail());
        kakaoDetailDTO.setKakaName(k.getKakaName());
        return kakaoDetailDTO;
    }
}
