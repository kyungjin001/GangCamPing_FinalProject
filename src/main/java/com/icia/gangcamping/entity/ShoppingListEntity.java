package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.GoodsSaveDTO;
import com.icia.gangcamping.dto.ShoppingListSaveDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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




    public static ShoppingListEntity toSaveEntity(ShoppingListSaveDTO shoppingListSaveDTO,OrderEntity orderEntity) {
        System.out.println(shoppingListSaveDTO);
        System.out.println(orderEntity);
        ShoppingListEntity shoppingListEntity = new ShoppingListEntity();
        shoppingListEntity.setShoppingListId(shoppingListSaveDTO.getShoppingListId());
        shoppingListEntity.setOrderEntity(orderEntity);
        shoppingListEntity.setShoppingListPrice(shoppingListSaveDTO.getShoppingListPrice());
        shoppingListEntity.setShoppingListDate(shoppingListSaveDTO.getShoppingListDate());
        return shoppingListEntity;
    }




}
