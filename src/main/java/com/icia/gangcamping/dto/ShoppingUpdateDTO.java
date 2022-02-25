package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ShoppingUpdateDTO {


    private Long productId;
    private String productName;
    private int productPrice;
    private int productWeight;
    private String productDescription;
    private MultipartFile productImage;
    private String productFileName;
    private int productStock;
    private int Stock;





//    public static ShoppingUpdateDTO toGoodsDetailDTO(ProductEntity goods){
//        ShoppingUpdateDTO goodsDetailDTO = new ShoppingUpdateDTO();
//        goodsDetailDTO.setProductId(goods.getProductId());
//        goodsDetailDTO.setProductName(goods.getProductName());
//        goodsDetailDTO.setProductPrice(goods.getProductPrice());
//        goodsDetailDTO.setProductWeight(goods.getProductWeight());
//        goodsDetailDTO.setProductDescription(goods.getProductDescription());
//        goodsDetailDTO.setProductFileName(goods.getProductFileName());
//        return goodsDetailDTO;
//    }







}
