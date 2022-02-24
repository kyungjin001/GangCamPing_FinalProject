package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.OrderSaveDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "order_table")
public class OrderEntity extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "orderId")
    private Long orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;
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
    private List<ShoppingListEntity> shoppingListEntityList = new ArrayList<>();



    public static OrderEntity toSaveEntity(OrderSaveDTO orderSaveDTO, MemberEntity memberEntity) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderPayType(orderSaveDTO.getOrderPayType());
        orderEntity.setOrderTotalFee(orderSaveDTO.getOrderTotalFee());
        orderEntity.setOrderUnitNum(orderSaveDTO.getOrderUnitNum());
        orderEntity.setOrderPayType("카카오페이");
        orderEntity.setOrderId(orderSaveDTO.getOrderId());
        orderEntity.setMemberEntity(memberEntity);
        return orderEntity;
    }



}
