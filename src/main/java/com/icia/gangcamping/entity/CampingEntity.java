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
@Table(name = "camping_table")
public class CampingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="campingId")
    private Long campingId;
    @Column
    @NotNull
    private String campingName;
    @Column
    @NotNull
    private String campingAddr;
    @Column
    @NotNull
    private String campingInfo;
    @Column
    @NotNull
    private String campingFileName;
    @Column
    @NotNull
    private String campingLikeCount;

    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<RoomEntity> roomEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CampingDetailEntity> campingDetailEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CampingPayEntity> campingPayEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<BookEntity> bookEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();
}
