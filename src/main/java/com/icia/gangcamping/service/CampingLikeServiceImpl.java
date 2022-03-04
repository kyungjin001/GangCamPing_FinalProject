package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CampingLikeDTO;
import com.icia.gangcamping.dto.CampingLikeDetailDTO;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.CampingLikeEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.repository.CampingLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CampingLikeServiceImpl implements CampingLikeService {

    private final CampingLikeRepository clr;
    private final MemberService ms;
    private final CampingService cs;

    @Override
    public Long save(CampingLikeDTO campingLikeDTO, String memberEmail) {
        MemberEntity memberEntity = ms.findByMemberEmail(memberEmail);
        CampingEntity campingEntity = cs.findById(campingLikeDTO.getCampingId()).get();
        campingEntity.setCampingLikeCount(campingEntity.getCampingLikeCount()+1);
        cs.save(campingEntity);
        CampingLikeEntity campingLikeEntity = CampingLikeEntity.toSaveCampingLike(campingLikeDTO,memberEntity,campingEntity);
       return clr.save(campingLikeEntity).getCampingLikeId();

    }

    @Override
    public CampingLikeDetailDTO findByMemberEntityAndCampingEntity(MemberEntity memberEntity, Optional<CampingEntity> camping) {
        CampingLikeEntity campingLike = clr.findByMemberEntityAndCampingEntity(memberEntity, camping);

        if(campingLike != null){
            CampingLikeDetailDTO campingLikeDetailDTO = CampingLikeDetailDTO.CampingLikeDetailDTO(campingLike);

            return campingLikeDetailDTO;
        }
        return null;
    }

    @Override
    public void deleteById(Long campingLikeId) {
        clr.deleteById(campingLikeId);
        CampingEntity camping = clr.findById(campingLikeId).get().getCampingEntity();
        camping.setCampingLikeCount(camping.getCampingLikeCount()-1);
        cs.save(camping);

    }

    @Override
    public List<CampingLikeDetailDTO> findByMemberEntity(MemberEntity memberEntity) {

        List<CampingLikeDetailDTO> campingLikeDTO = new ArrayList<>();
        List<CampingLikeEntity> campingLikeEntity = clr.findByMemberEntity(memberEntity);
        for(CampingLikeEntity campingLike: campingLikeEntity){
            campingLikeDTO.add(CampingLikeDetailDTO.CampingLikeDetailDTO(campingLike));
        }
        return campingLikeDTO;
    }


}
