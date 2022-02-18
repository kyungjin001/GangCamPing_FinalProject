package com.icia.gangcamping.service;

import com.icia.gangcamping.entity.CampingDetailEntity;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.repository.CampingDetailRepository;
import com.icia.gangcamping.repository.CampingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
