package com.icia.gangcamping.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class CampingSaveDTO {


    private String campingName;

    private String campingAddr;

    private String campingInfo;

    private String campingFileName;

    private int campingLikeCount;

}
