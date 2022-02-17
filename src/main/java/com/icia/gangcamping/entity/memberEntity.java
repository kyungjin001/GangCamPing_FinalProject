package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.MemberSaveDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class memberEntity {
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
    private List<campingLikeEntity> campingLikeEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<campingPayEntity> campingPayEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<bookEntity> bookEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<cartEntity> cartEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<orderEntity> orderEntityList= new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<shoppingLikeEntity> shoppingLikeEntityList= new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<questionEntity> questionEntityList= new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<reviewEntity> reviewEntityList= new ArrayList<>();
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<chattingEntity> chattingEntityList= new ArrayList<>();

    public static memberEntity saveMember(MemberSaveDTO memberSaveDTO) {
        memberEntity memberEntity = new memberEntity();
        memberEntity.setMemberEmail(memberSaveDTO.getMemberEmail());
        memberEntity.setMemberPw(memberSaveDTO.getMemberPw());
        memberEntity.setMemberName(memberSaveDTO.getMemberName());
        memberEntity.setMemberAddr(memberSaveDTO.getMemberAddr());
        memberEntity.setMemberPhone(memberSaveDTO.getMemberPhone());
        return memberEntity;
    }
}
