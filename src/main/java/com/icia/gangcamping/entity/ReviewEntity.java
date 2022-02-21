package com.icia.gangcamping.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "review_table")
public class ReviewEntity extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "reviewId")
    private Long reviewId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingId")
    private CampingEntity campingEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;
    @Column
    @NotNull
    private String reviewTitle;
    @Column
    @NotNull
    private String reviewContents;
    @Column
    @NotNull
    private double reviewStar;
    @Column
    @NotNull
    private String reviewFileName;
}
