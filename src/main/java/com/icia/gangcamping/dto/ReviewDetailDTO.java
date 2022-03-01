package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ReviewEntity;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ReviewDetailDTO {

    private CampingEntity campingEntity;
    private MemberEntity memberEntity;
    private String reviewContents;
    private double reviewStar;
    private String reviewWriter;
    private String campingName;
    private String reviewTitle;
    private String campingFileName;
    private LocalDateTime createTime;

    public static ReviewDetailDTO toDetailDTO(ReviewEntity reviewEntity) {
        ReviewDetailDTO reviewDetailDTO = new ReviewDetailDTO();
        System.out.println("fd"+reviewEntity.toString());
        reviewDetailDTO.setReviewStar(reviewEntity.getReviewStar());
        reviewDetailDTO.setReviewContents(reviewEntity.getReviewContents());
        reviewDetailDTO.setReviewWriter(reviewEntity.getMemberEntity().getMemberEmail());
        reviewDetailDTO.setCampingName(reviewEntity.getCampingEntity().getCampingName());
        reviewDetailDTO.setCampingFileName(reviewEntity.getCampingEntity().getCampingFileName());
        reviewDetailDTO.setCreateTime(reviewEntity.getCreateTime());
        reviewDetailDTO.setReviewTitle(reviewEntity.getReviewTitle());
        return reviewDetailDTO;
    }
}
