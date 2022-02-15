package com.icia.gangcamping.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "shoppingList_table")
public class ShoppingListEntity {
    @Id
    @GeneratedValue
    @Column(name = "shoppingListId")
    private Long shoppingListId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private OrderEntity orderEntity;
    @Column
    @NotNull
    private int shoppingListPrice;
    @Column
    @NotNull
    private LocalDateTime shoppingListDate;

}
