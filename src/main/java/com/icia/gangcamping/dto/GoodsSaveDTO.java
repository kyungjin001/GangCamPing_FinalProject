package com.icia.gangcamping.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GoodsSaveDTO {



    private String productName;
    private int productPrice;
    private int productWeight;
    private String productDescription;
    private MultipartFile productImage;
    private String productFileName;
    private int productStock;



}
