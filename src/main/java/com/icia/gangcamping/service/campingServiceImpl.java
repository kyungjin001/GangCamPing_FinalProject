package com.icia.gangcamping.service;

import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.repository.CampingRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor
public class campingServiceImpl implements campingService{
    private final CampingRepository campingRepository;
    @Override
    public void save(CampingEntity entity) {
        campingRepository.save(entity);
    }
}
