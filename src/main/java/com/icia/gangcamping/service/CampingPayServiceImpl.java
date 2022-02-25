package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CampingPayDetailDTO;
import com.icia.gangcamping.dto.CampingPaySaveDTO;
import com.icia.gangcamping.entity.BookEntity;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.CampingPayEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.repository.BookRepository;
import com.icia.gangcamping.repository.CampingPayRepository;
import com.icia.gangcamping.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampingPayServiceImpl implements CampingPayService{

    private final CampingPayRepository cpr;
    private final MemberService ms;
    private final CampingService cs;
    private final BookRepository bs;

    @Override
    public Long save(CampingPaySaveDTO campingPaySaveDTO) {

        MemberEntity memberEntity = ms.findByMemberId(campingPaySaveDTO.getMemberId()).get();
        CampingEntity campingEntity = cs.findById(campingPaySaveDTO.getCampingId()).get();
        BookEntity bookEntity = bs.findById(campingPaySaveDTO.getBookId()).get();
        CampingPayEntity campingPayEntity = CampingPayEntity.toSave(campingPaySaveDTO, memberEntity, campingEntity, bookEntity);
        return cpr.save(campingPayEntity).getCampingPayId();
    }



}
