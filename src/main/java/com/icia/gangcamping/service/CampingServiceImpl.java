package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CampingDetailDTO;
import com.icia.gangcamping.dto.CampingDetailSaveDTO;
import com.icia.gangcamping.entity.CampingDetailEntity;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.repository.CampingDetailRepository;
import com.icia.gangcamping.repository.CampingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class CampingServiceImpl implements CampingService {
    private final CampingRepository campingRepository;
    private final CampingDetailRepository cdr;
    @Override
    public void save(CampingEntity entity) {
        System.out.println(entity);
        campingRepository.save(entity);
    }

    @Override
    public Optional<CampingEntity> findById(long l) {
        return campingRepository.findById(l);
    }

    @Override
    public void saveDetail(CampingDetailEntity entity) {
        cdr.save(entity);
    }

    @Override
    public CampingDetailDTO findByCampingName(String campingName) {
        System.out.println("csName="+campingName);
        CampingEntity entity = campingRepository.findByCampingName(campingName);
        System.out.println(entity.getCampingName());

        System.out.println(campingName+"222222222222222222");
        System.out.println(entity.toString());
        CampingDetailDTO campingDetailDTO = CampingDetailDTO.toCampingDetailDTO(entity);

        return campingDetailDTO;
    }

    @Override
    public List findAll() {
        return campingRepository.findAll(Sort.by(Sort.Direction.DESC,"CampingName"));
    }

    @Override
    public List<CampingDetailDTO> findTop3AllOrderByCampingLikeCount() {
        List<CampingEntity> list = campingRepository.findTop4ByOrderByCampingLikeCountDesc();
        List<CampingDetailDTO> dtoList = new ArrayList<>();
        for( CampingEntity entity : list){
            CampingDetailDTO camping = CampingDetailDTO.toCampingDetailDTO(entity);
            if(camping.getCampingFileName()==null){
                System.out.println("service null");
                camping.setCampingFileName("/images/noImage.jpg");
            }
            dtoList.add(camping);
        }
        return dtoList;
    }

    @Override
    public CampingEntity findByCampingName1(String campingName) {
        return campingRepository.findByCampingName(campingName);
    }

    @Override
    public CampingDetailSaveDTO findByCampingEntity(CampingEntity campingEntity) {
        CampingDetailEntity campingDetailEntity = cdr.findByCampingEntity(campingEntity);
        CampingDetailSaveDTO campingDetailSaveDTO = CampingDetailSaveDTO.toSaveDTO(campingDetailEntity);
        return campingDetailSaveDTO;
    }

}
