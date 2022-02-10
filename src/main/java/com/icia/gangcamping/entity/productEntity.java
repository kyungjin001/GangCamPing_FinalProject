package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "product_table")
public class productEntity {
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

    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<stockEntity> stockEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<cartEntity> cartEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<orderEntity> orderEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<shoppingLikeEntity> shoppingLikeEntityArrayList = new ArrayList<>();
    @OneToMany(mappedBy = "productEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<questionEntity> questionEntityList = new ArrayList<>();

}
