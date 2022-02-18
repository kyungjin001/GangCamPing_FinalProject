package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.CampingEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class CampingDetailSaveDTO {


    private CampingEntity campingEntity;

    private String facility1;

    private String facility2;

    private String facility3;

    private String facility4;

    private String facility5;

    private String facility6;

    private String facility7;

    private String facility8;
}
