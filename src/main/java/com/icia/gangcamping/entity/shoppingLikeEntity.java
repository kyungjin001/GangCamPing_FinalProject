package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "shoppingLike_table")
public class shoppingLikeEntity extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "shoppingLikeId")
    private Long shoppingLikeId;
    @Column

    private Long memberId;
    @Column

    private Long productId;
    @Column
    @NotNull
    private LocalDateTime shoppingLikeDate;


}
