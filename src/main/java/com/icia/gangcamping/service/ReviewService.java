package com.icia.gangcamping.service;


import com.icia.gangcamping.dto.ReviewDetailDTO;
import com.icia.gangcamping.dto.ReviewSaveDTO;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.MemberEntity;

import java.util.List;

public interface ReviewService {
    void save(ReviewSaveDTO reviewSaveDTO);

    ReviewDetailDTO findById(int rnd);

    List<ReviewDetailDTO> findAll(Long campingId);

    double avg(Long campingId);
}
