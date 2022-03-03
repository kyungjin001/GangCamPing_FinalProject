package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.GoodsDetailDTO;
import com.icia.gangcamping.dto.GoodsSaveDTO;
import com.icia.gangcamping.dto.ShoppingUpdateDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "product_table")
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productId")
    private Long productId;
    @Column
    @NotNull
    private String productName;
    @Column
    @NotNull
    private int productPrice;
    @Column
    @NotNull
    private int productWeight;
    @Column
    @NotNull
    private String productDescription;
    @Column
    @NotNull
    private String productFileName;

    @OneToOne(mappedBy = "productEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private StockEntity stockEntity;
    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CartEntity> cartEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ShoppingLikeEntity> shoppingLikeEntityArrayList = new ArrayList<>();
    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<QuestionEntity> questionEntityList = new ArrayList<>();



    public static ProductEntity toSaveEntity(GoodsSaveDTO goodsSaveDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(goodsSaveDTO.getProductName());
        productEntity.setProductWeight(goodsSaveDTO.getProductWeight());
        productEntity.setProductPrice(goodsSaveDTO.getProductPrice());
        productEntity.setProductDescription(goodsSaveDTO.getProductDescription());
        productEntity.setProductFileName(goodsSaveDTO.getProductFileName());
        return productEntity;
    }


    public static ProductEntity toUpdateBoard(ShoppingUpdateDTO shoppingUpdateDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(shoppingUpdateDTO.getProductName());
        productEntity.setProductId(shoppingUpdateDTO.getProductId());
        productEntity.setProductWeight(shoppingUpdateDTO.getProductWeight());
        productEntity.setProductPrice(shoppingUpdateDTO.getProductPrice());
        productEntity.setProductDescription(shoppingUpdateDTO.getProductDescription());
        productEntity.setProductFileName(shoppingUpdateDTO.getProductFileName());
        return productEntity;
    }


}
