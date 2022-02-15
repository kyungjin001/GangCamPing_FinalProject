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
@Table(name = "room_table")
public class roomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roomId")
    private Long roomId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingId")
    private campingEntity campingEntity;
    @Column
    @NotNull
    private String roomName;
    @Column
    @NotNull
    private String roomPrice;
    @Column
    @NotNull
    private String roomInfo;
    @Column
    @NotNull
    private String roomFileName;
    @Column
    @NotNull
    private String roomCategory;

    @OneToMany(mappedBy = "roomEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<campingPayEntity> campingPayEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "roomEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<bookEntity> bookEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "roomEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<bookListEntity> bookListEntityList = new ArrayList<>();

}
