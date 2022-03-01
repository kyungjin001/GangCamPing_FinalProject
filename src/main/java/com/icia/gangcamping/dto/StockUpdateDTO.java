package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.ProductEntity;
import com.icia.gangcamping.entity.StockEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StockUpdateDTO {


    private Long stockId;
    private Long productId;
    private int Stock;
    private String productName;
    private int productWeight;
    private ProductEntity productEntity;


    public static StockUpdateDTO toStockUpdateDTO(StockEntity stock) {
        System.out.println("sss" + stock);
        StockUpdateDTO stockUpdateDTO = new StockUpdateDTO();
        stockUpdateDTO.setStockId(stock.getStockId());
        stockUpdateDTO.setProductId(stock.getProductEntity().getProductId());
        stockUpdateDTO.setStock(stock.getStock());
        stockUpdateDTO.setProductName(stock.getProductEntity().getProductName());
        stockUpdateDTO.setProductWeight(stock.getProductEntity().getProductWeight());
        stockUpdateDTO.setProductEntity(stock.getProductEntity());

    return stockUpdateDTO;
    }
}


