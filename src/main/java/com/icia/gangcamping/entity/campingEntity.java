package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "camping_table")
public class campingEntity {
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
    private List<roomEntity> roomEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<campingDetailEntity> campingDetailEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<campingPayEntity> campingPayEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<bookEntity> bookEntityList = new ArrayList<>();
}
