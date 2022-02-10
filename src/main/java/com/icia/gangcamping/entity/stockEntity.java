package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "stock_table")
public class stockEntity {
    @Id
    @GeneratedValue
    @Column(name = "stockId")
    private Long stockId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private productEntity productEntity;
    @Column
    @NotNull
    private int stock;
}
