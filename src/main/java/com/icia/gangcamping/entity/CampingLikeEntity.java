package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.CampingLikeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "campingLike_table")
public class CampingLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="campingLikeId")
    private Long CampingLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingId")
    private CampingEntity campingEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;


    public static CampingLikeEntity toSaveCampingLike(CampingLikeDTO campingLikeDTO, MemberEntity memberEntity, CampingEntity campingEntity) {


        CampingLikeEntity campingLikeEntity = new CampingLikeEntity();

        campingLikeEntity.setCampingEntity(campingEntity);
        campingLikeEntity.setMemberEntity(memberEntity);
        return campingLikeEntity;
    }
}
