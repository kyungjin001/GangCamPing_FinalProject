package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.ShoppingLikeSaveDTO;
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
@Table(name = "shoppingLike_table")
public class ShoppingLikeEntity{
    @Id
    @GeneratedValue
    @Column(name = "shoppingLikeId")
    private Long shoppingLikeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private ProductEntity productEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;



    public static ShoppingLikeEntity toSaveEntity(ShoppingLikeSaveDTO shoppingLikeSaveDTO, MemberEntity memberEntity,ProductEntity ProductEntity) {
        ShoppingLikeEntity shoppingLike = new ShoppingLikeEntity();
        shoppingLike.setMemberEntity(memberEntity);
        shoppingLike.setProductEntity(ProductEntity);
        return shoppingLike;
    }


}
