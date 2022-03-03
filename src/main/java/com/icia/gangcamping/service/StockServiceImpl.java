package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.*;
import com.icia.gangcamping.entity.*;
import com.icia.gangcamping.repository.CartRepository;
import com.icia.gangcamping.repository.ProductRepositroy;
import com.icia.gangcamping.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor


public class StockServiceImpl implements StockService {

    private final ProductRepositroy pr;
    private final CartRepository cr;
    private final StockRepository tr;


//    @Override
//    public Long save(GoodsSaveDTO goodsSaveDTO) throws IOException {
//
//
//
//        ProductEntity productEntity = ProductEntity.toSaveEntity(goodsSaveDTO);
//        Long result =  pr.save(productEntity).getProductId();
//
//        return result;
//
//
//
//    }


//    @Override
//    public Long save(OrderSaveDTO orderSaveDTO) {
//        System.out.println(orderSaveDTO);
//        Optional<MemberEntity> memberEntity = mr.findById(orderSaveDTO.getMemberId());
//        OrderEntity orderEntity = OrderEntity.toSaveEntity(orderSaveDTO,memberEntity.get());
//        Long result =  or.save(orderEntity).getOrderId();
//        return result;
//    }


    @Override
    public List<StockDetailDTO> findAll() {
        List<StockEntity> stockEntityList = tr.findAll();
        List<StockDetailDTO> stockList = new ArrayList<>();
        for (StockEntity s : stockEntityList) {
            StockDetailDTO stockDetailDTO = StockDetailDTO.toStockDetailDTO(s);
            stockDetailDTO.setProductName(s.getProductEntity().getProductName());
            stockDetailDTO.setProductWeight(s.getProductEntity().getProductWeight());
            stockList.add(stockDetailDTO);

        }
        return stockList;
    }

    @Override
    public void save(StockSaveDTO stockSaveDTO) {
        System.out.println("세이브 디티오" + stockSaveDTO);
        Optional<ProductEntity> productEntity = pr.findById(stockSaveDTO.getProductId());
        StockEntity stockEntity = StockEntity.toSaveEntity(stockSaveDTO, productEntity.get());
        tr.save(stockEntity);
    }

    @Override
    public String stockUpDown(Long stockId, String type) {
        Optional<StockEntity> stockEntity = tr.findById(stockId);
        if (type.equals("up")) {
            stockEntity.get().setStock(stockEntity.get().getStock() + 1);
            tr.save(stockEntity.get());
        } else {
            stockEntity.get().setStock(stockEntity.get().getStock() - 1);
            tr.save(stockEntity.get());
        }
        return "ok";
    }

    @Override
    public void update(StockUpdateDTO stockUpdateDTO) {
       StockEntity stock = StockEntity.toUpdateStock(stockUpdateDTO);
        System.out.println(stock.toString());

        tr.save(stock);
    }

    @Override
    public StockUpdateDTO findByProductEntity(ProductEntity byId) {
                System.out.println("dscxcxcx"+byId);
        StockEntity stockEntity = tr.findByProductEntity(byId);
        StockUpdateDTO stockUpdateDTO = StockUpdateDTO.toStockUpdateDTO(stockEntity);
        return stockUpdateDTO;
    }

//    @Override
//    public StockDetailDTO findByProductEntity(Optional<ProductEntity> byId) {
//        System.out.println("dscxcxcx"+byId);
//       StockEntity stockEntity = tr.findByProductEntity(byId);
//       StockDetailDTO stockDetailDTO = StockDetailDTO.toStockDetailDTO(stockEntity);
//        return stockDetailDTO;
//    }

}
