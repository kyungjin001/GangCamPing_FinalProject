package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface StockService {



//    Long save(StockDetailDTO stockDetailDTO , ProductEntity productEntity);

    List<StockDetailDTO> findAll();

    void save(StockSaveDTO stockSaveDTO);

    String stockUpDown(Long stockId, String type);

    void update(StockUpdateDTO stockUpdateDTO);

    StockUpdateDTO findByProductEntity(ProductEntity byId);

//    StockDetailDTO findByProductEntity(Optional<ProductEntity> byId);


//    GoodsDetailDTO findById(Long productId);




}
