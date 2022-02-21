package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Getter
@Setter
@Table(name="kakao")
public class KakaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kakaoId")
    private Long id;

    @Column
    private String kakaName;

    @Column
    private String kakaEmail;


    public static KakaoEntity saveKakao(HashMap<String, Object> userInfo) {

        KakaoEntity kakaoEntity = new KakaoEntity();

        kakaoEntity.setKakaEmail((String) userInfo.get("email"));
        kakaoEntity.setKakaName((String) userInfo.get("nickname"));

        return kakaoEntity;
    }
}
