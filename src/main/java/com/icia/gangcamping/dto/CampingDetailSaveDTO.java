package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.CampingDetailEntity;
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

    public static CampingDetailSaveDTO toSaveDTO(CampingDetailEntity campingDetailEntity) {
        CampingDetailSaveDTO campingDetailSaveDTO = new CampingDetailSaveDTO();

        campingDetailSaveDTO.setCampingEntity(campingDetailEntity.getCampingEntity());
        campingDetailSaveDTO.setFacility1(campingDetailEntity.getFacility1());
        campingDetailSaveDTO.setFacility2(campingDetailEntity.getFacility2());
        campingDetailSaveDTO.setFacility3(campingDetailEntity.getFacility3());
        campingDetailSaveDTO.setFacility4(campingDetailEntity.getFacility4());
        campingDetailSaveDTO.setFacility5(campingDetailEntity.getFacility5());
        campingDetailSaveDTO.setFacility6(campingDetailEntity.getFacility6());
        campingDetailSaveDTO.setFacility7(campingDetailEntity.getFacility7());
        campingDetailSaveDTO.setFacility8(campingDetailEntity.getFacility8());
        return campingDetailSaveDTO;
    }
}
