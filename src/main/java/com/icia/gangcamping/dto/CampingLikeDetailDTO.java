package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.CampingLikeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampingLikeDetailDTO {

    private Long campingLikeId;
    private Long memberId;
    private Long campingId;
    private String campingName;
    private String campingInfo;
    private String memberEmail;


    public static CampingLikeDetailDTO CampingLikeDetailDTO(CampingLikeEntity campingLike) {
        CampingLikeDetailDTO campingLikeDetailDTO = new CampingLikeDetailDTO();

        campingLikeDetailDTO.setCampingLikeId(campingLike.getCampingLikeId());
        campingLikeDetailDTO.setCampingId(campingLike.getCampingEntity().getCampingId());
        campingLikeDetailDTO.setMemberId(campingLike.getMemberEntity().getMemberId());
        campingLikeDetailDTO.setCampingName(campingLike.getCampingEntity().getCampingName());
        campingLikeDetailDTO.setCampingInfo(campingLike.getCampingEntity().getCampingInfo());
        campingLikeDetailDTO.setMemberEmail(campingLike.getMemberEntity().getMemberEmail());
        return campingLikeDetailDTO;
    }
}