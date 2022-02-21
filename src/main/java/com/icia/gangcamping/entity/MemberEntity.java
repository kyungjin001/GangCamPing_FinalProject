package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.MemberSaveDTO;
import com.icia.gangcamping.dto.MemberUpdateDTO;
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

    @Column
    private String memberEmail;
    @Column
    private String memberPw;

    @Column
    private String memberName;

    @Column
    private String memberAddr;

    @Column
    private String memberPhone;

    // 캠핑내역
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.PERSIST, orphanRemoval = false,fetch = FetchType.LAZY)
    private List<CampingLikeEntity> campingLikeEntityList = new ArrayList<>();
    // 캠핑결제
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CampingPayEntity> campingPayEntityList = new ArrayList<>();
    // 예약내역
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<BookEntity> bookEntityList = new ArrayList<>();
    // 장바구니
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CartEntity> cartEntityList = new ArrayList<>();
    // 주문내역
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<OrderEntity> orderEntityList= new ArrayList<>();
    // 쇼핑 좋아요
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ShoppingLikeEntity> shoppingLikeEntityList= new ArrayList<>();
    // 질문
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<QuestionEntity> questionEntityList= new ArrayList<>();
    // 답변
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ReviewEntity> reviewEntityList= new ArrayList<>();

    // 메일인증
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<MailEntity> MailEntityList= new ArrayList<>();

    // 채팅
    /*@OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ChattingEntity> chattingEntityList= new ArrayList<>();*/

    public static MemberEntity saveMember(MemberSaveDTO memberSaveDTO) {
        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setMemberEmail(memberSaveDTO.getMemberEmail());
        memberEntity.setMemberPw(memberSaveDTO.getMemberPw());
        memberEntity.setMemberName(memberSaveDTO.getMemberName());
        memberEntity.setMemberAddr(memberSaveDTO.getMemberAddr());
        memberEntity.setMemberPhone(memberSaveDTO.getMemberPhone());
        return memberEntity;
    }

    public static MemberEntity toUpdateMember(MemberUpdateDTO memberUpdateDTO) {

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberUpdateDTO.getMemberId());
        memberEntity.setMemberEmail(memberUpdateDTO.getMemberEmail());
        memberEntity.setMemberPw(memberUpdateDTO.getMemberPw());
        memberEntity.setMemberName(memberUpdateDTO.getMemberName());
        memberEntity.setMemberAddr(memberUpdateDTO.getMemberAddr());
        memberEntity.setMemberPhone(memberUpdateDTO.getMemberPhone());
        return memberEntity;
    }
}
