package com.icia.gangcamping.dto;

import com.icia.gangcamping.entity.CampingEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
public class RoomSaveDTO {

    private Long campingId;
    private String roomName;
    private String roomPrice;
    private String roomInfo;
    private String roomFileName;
    private String roomCategory;
}
