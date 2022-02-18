package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.CartDetailDTO;
import com.icia.gangcamping.dto.GoodsSaveDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "cart_table")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cartId")
    private Long cartId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private ProductEntity productEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;
    @Column
    @NotNull
    private int deliveryFee;
    @Column
    @NotNull
    private int cartPriceSum;
    @Column
    @NotNull
    private int cartAmount;



    public static CartEntity toSaveEntity(CartDetailDTO cartDetailDTO,MemberEntity memberEntity,ProductEntity productEntity) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setMemberEntity(memberEntity);
        cartEntity.setProductEntity(productEntity);
        return cartEntity;
    }




}
