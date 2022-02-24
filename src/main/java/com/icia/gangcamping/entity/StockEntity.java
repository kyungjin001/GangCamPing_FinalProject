package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "stock_table")
public class StockEntity {
    @Id
    @GeneratedValue
    @Column(name = "stockId")
    private Long stockId;
    @ManyToOne(fetch = FetchType.LAZY)
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


//    public static StockEntity toUpdateStock(StockUpdateDTO stockUpdateDTO) {
//        BoardEntity boardEntity = new BoardEntity();
//
//        boardEntity.setId(boardDetailDTO.getBoardId());
//        boardEntity.setBoardWriter(boardDetailDTO.getBoardWriter());
//        boardEntity.setBoardTitle(boardDetailDTO.getBoardTitle());
//        boardEntity.setBoardContents(boardDetailDTO.getBoardContents());
//        boardEntity.setBoardImageName(boardDetailDTO.getBoardImageName());
////        boardEntity.setBoardDate(LocalDateTime.now());
//
//        return boardEntity;
//    }



}



