package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.CampingDetailSaveDTO;
import lombok.*;
import org.w3c.dom.Text;

import javax.persistence.*;

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
    @Column(columnDefinition="TEXT")
    private String  facility2;
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

    public CampingDetailEntity dtoToEntity(CampingDetailSaveDTO saveDTO) {
        CampingDetailEntity entity = new CampingDetailEntity();
        entity.setCampingEntity(saveDTO.getCampingEntity());
        entity.setFacility1(saveDTO.getFacility1());
        entity.setFacility2(saveDTO.getFacility2());
        entity.setFacility3(saveDTO.getFacility3());
        entity.setFacility4(saveDTO.getFacility4());
        entity.setFacility5(saveDTO.getFacility5());
        entity.setFacility6(saveDTO.getFacility6());
        entity.setFacility7(saveDTO.getFacility7());
        entity.setFacility8(saveDTO.getFacility8());
        return entity;

    }
}
