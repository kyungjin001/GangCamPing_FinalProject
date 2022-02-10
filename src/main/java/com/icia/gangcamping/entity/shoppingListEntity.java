package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "shoppingList_table")
public class shoppingListEntity {
    @Id
    @GeneratedValue
    @Column(name = "shoppingListId")
    private Long shoppingListId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private orderEntity orderEntity;
    @Column
    @NotNull
    private int shoppingListPrice;
    @Column
    @NotNull
    private LocalDateTime shoppingListDate;

}
