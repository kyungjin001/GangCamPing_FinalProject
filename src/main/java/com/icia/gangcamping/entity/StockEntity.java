package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "stock_table")
public class StockEntity {
    @Id
    @GeneratedValue
    @Column(name = "stock_Id")
    private Long stockId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private ProductEntity productEntity;
    @Column
    @NotNull
    private int stock;

    public static StockEntity toSaveEntity(StockSaveDTO stockSaveDTO, ProductEntity productEntity) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setStock(stockSaveDTO.getStock());
        stockEntity.setProductEntity(productEntity);
        return stockEntity;
    }


    public static StockEntity toUpdateStock(StockUpdateDTO stockUpdateDTO) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setStock(stockUpdateDTO.getStock());
        stockEntity.setStockId(stockUpdateDTO.getStockId());
        stockEntity.setProductEntity(stockUpdateDTO.getProductEntity());

        return stockEntity;
    }



}



