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
public class ShoppingUpdateDTO {


    private Long productId;
    private String productName;
    private int productPrice;
    private int productWeight;
    private String productDescription;
    private MultipartFile productImage;
    private String productFileName;
    private int productStock;
    private LocalDateTime productTime;
    private int Stock;












}
