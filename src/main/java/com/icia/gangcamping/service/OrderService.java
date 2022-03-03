package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.MemberDetailDTO;
import com.icia.gangcamping.dto.OrderDetailDTO;
import com.icia.gangcamping.dto.OrderSaveDTO;
import com.icia.gangcamping.dto.ShoppingListDetailDTO;
import com.icia.gangcamping.entity.MemberEntity;

import java.util.List;

public interface OrderService {
    Long save(OrderSaveDTO orderSaveDTO);

    OrderDetailDTO findById(Long result);

    List<ShoppingListDetailDTO> findAll();


//
//
//
//    void findAll(Long productId, Long memberId);
}
