package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.CartEntity;
import com.icia.gangcamping.entity.StockEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StockDetailDTO {


    private Long stockId;
    private Long productId;
    private int Stock;
    private String productName;
    private int productWeight;



    public static StockDetailDTO toStockDetailDTO (StockEntity stock){
        StockDetailDTO stockDetailDTO = new StockDetailDTO();
        stockDetailDTO.setProductId(stock.getProductEntity().getProductId());
        stockDetailDTO.setProductName(stock.getProductEntity().getProductName());
        stockDetailDTO.setProductWeight(stock.getProductEntity().getProductWeight());
        stockDetailDTO.setStock(stock.getStock());
        stockDetailDTO.setProductId(stock.getProductEntity().getProductId());
        stockDetailDTO.setStockId(stock.getStockId());
//
        return stockDetailDTO;
    }}



