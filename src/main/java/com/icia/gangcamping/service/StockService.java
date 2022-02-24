package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface StockService {



//    Long save(StockDetailDTO stockDetailDTO , ProductEntity productEntity);

    List<StockDetailDTO> findAll();

    void save(StockSaveDTO stockSaveDTO);

    String stockUpDown(Long stockId, String type);

    void update(StockUpdateDTO stockUpdateDTO);


//    GoodsDetailDTO findById(Long productId);




}
