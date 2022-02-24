package com.icia.gangcamping.dto;


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



    public static StockUpdateDTO toStockDetailDTO (StockEntity stock){
        StockUpdateDTO stockDetailDTO = new StockUpdateDTO();
        stockDetailDTO.setProductId(stock.getProductEntity().getProductId());
        stockDetailDTO.setProductName(stock.getProductEntity().getProductName());
        stockDetailDTO.setProductWeight(stock.getProductEntity().getProductWeight());
        stockDetailDTO.setStock(stock.getStock());
        stockDetailDTO.setProductId(stock.getProductEntity().getProductId());
        stockDetailDTO.setStockId(stock.getStockId());
//
        return stockDetailDTO;
    }}



