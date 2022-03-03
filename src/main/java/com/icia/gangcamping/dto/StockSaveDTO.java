package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.StockEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StockSaveDTO {



    private Long stockId;
    private Long productId;
    private int Stock;


    public static StockSaveDTO toSaveDTO(StockEntity byProductEntity) {

        StockSaveDTO stockSaveDTO = new StockSaveDTO();
        stockSaveDTO.setStockId(byProductEntity.getStockId());
        stockSaveDTO.setProductId(byProductEntity.getProductEntity().getProductId());
        return stockSaveDTO;
    };
}
