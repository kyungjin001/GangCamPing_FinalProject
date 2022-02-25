package com.icia.gangcamping.service;

import com.icia.gangcamping.repository.ProductRepositroy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ProductRepositroy pr;



    @Override
    public void deleteById(Long productId) {
        pr.deleteById(productId);
    }
}
