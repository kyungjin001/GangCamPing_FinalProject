package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GoodsDetailDTO {


    private Long productId;
    private String productName;
    private int productPrice;
    private int productWeight;
    private String productDescription;
    private MultipartFile productImage;
    private String productFileName;
    private int productStock;
    private LocalDateTime productTime;






    public static GoodsDetailDTO toGoodsDetailDTO(ProductEntity goods){
        GoodsDetailDTO goodsDetailDTO = new GoodsDetailDTO();
        goodsDetailDTO.setProductId(goods.getProductId());
        goodsDetailDTO.setProductName(goods.getProductName());
        goodsDetailDTO.setProductPrice(goods.getProductPrice());
        goodsDetailDTO.setProductWeight(goods.getProductWeight());
        goodsDetailDTO.setProductDescription(goods.getProductDescription());
        goodsDetailDTO.setProductFileName(goods.getProductFileName());
        goodsDetailDTO.setProductTime(goods.getCreateTime());
        if(goods.getUpdateTime()==null){
            goodsDetailDTO.setProductTime(goods.getCreateTime());
        }else {
            goodsDetailDTO.setProductTime(goods.getUpdateTime());
        }
        return goodsDetailDTO;
    }







}
