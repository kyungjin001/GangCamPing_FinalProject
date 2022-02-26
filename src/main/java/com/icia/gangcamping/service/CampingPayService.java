package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CampingLikeDTO;
import com.icia.gangcamping.dto.CampingPayDetailDTO;
import com.icia.gangcamping.dto.CampingPaySaveDTO;

import java.util.List;

public interface CampingPayService {
    Long save(CampingPaySaveDTO campingPaySaveDTO);

}
