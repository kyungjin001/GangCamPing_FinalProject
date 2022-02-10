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
@Table(name = "order_table")
public class orderEntity extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "orderId")
    private Long orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private productEntity productEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private memberEntity memberEntity;
    @Column
    @NotNull
    private int orderUnitNum;
    @Column
    @NotNull
    private int orderTotalFee;
    @Column
    @NotNull
    private String orderPayType;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<shoppingListEntity> shoppingListEntityList = new ArrayList<>();
}
