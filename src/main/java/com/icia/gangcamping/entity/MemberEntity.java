package com.icia.gangcamping.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="memberId")
    private Long memberId;
    @Column(unique = true)
    private String memberEmail;
    @Column
    @NotNull
    private String memberPw;
    @NotNull
    @Column
    private String memberName;
    @Column
    @NotNull
    private String memberAddr;
    @Column
    @NotNull
    private String memberPhone;
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.PERSIST, orphanRemoval = false,fetch = FetchType.LAZY)
    private List<CampingLikeEntity> campingLikeEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CampingPayEntity> campingPayEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<BookEntity> bookEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CartEntity> cartEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<OrderEntity> orderEntityList= new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ShoppingLikeEntity> shoppingLikeEntityList= new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<QuestionEntity> questionEntityList= new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ReviewEntity> reviewEntityList= new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ChattingEntity> chattingEntityList= new ArrayList<>();
}
