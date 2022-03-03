package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;
import lombok.Data;

@Data
public class ReviewSaveDTO {
    private int reviewStar;
    private String reviewWriter;
    private String reviewContents;
    private String reviewTitle;
    private String campingName;




}
