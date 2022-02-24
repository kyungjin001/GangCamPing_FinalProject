package com.icia.gangcamping.entity;

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
    @Column(name = "stockId")
    private Long stockId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private ProductEntity productEntity;
    @Column
    @NotNull
    private int stock;
}
