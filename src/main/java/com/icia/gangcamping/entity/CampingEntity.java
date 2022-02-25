package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.CampingSaveDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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
    private String campingName;

    @Column
    private String campingAddr;

    @Column
    private String campingInfo;

    @Column
    private String campingFileName;

    @Column
    @NotNull
    private int campingLikeCount;


    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CampingDetailEntity> campingDetailEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CampingPayEntity> campingPayEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<BookEntity> bookEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "campingEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();


    public CampingEntity dtoToEntity(CampingSaveDTO campingSaveDTO) {
        CampingEntity entity = new CampingEntity();
        System.out.println(campingSaveDTO.toString()+"campingsaveDTO");
        entity.setCampingAddr(campingSaveDTO.getCampingAddr());
        entity.setCampingInfo(campingSaveDTO.getCampingInfo());
        entity.setCampingFileName(campingSaveDTO.getCampingFileName());
        entity.setCampingName(campingSaveDTO.getCampingName());
        entity.setCampingLikeCount(campingSaveDTO.getCampingLikeCount());
        System.out.println("campingEntity="+entity.toString());
        return entity;

    }
}
