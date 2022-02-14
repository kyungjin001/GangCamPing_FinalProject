package com.icia.gangcamping.entity;

import lombok.*;

import javax.persistence.*;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "campingDetail_table")
public class CampingDetailEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column
    private Long campingDetailId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingId")
    private CampingEntity campingEntity;
    @Column
    private String facility1;
    @Column
    private String facility2;
    @Column
    private String facility3;
    @Column
    private String facility4;
    @Column
    private String facility5;
    @Column
    private String facility6;
    @Column
    private String facility7;
    @Column
    private String facility8;

}
