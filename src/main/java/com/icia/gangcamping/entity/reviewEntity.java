package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "review_table")
public class reviewEntity extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "reviewId")
    private Long reviewId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingId")
    private campingEntity campingEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private memberEntity memberEntity;
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
