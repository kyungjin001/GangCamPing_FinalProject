package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CampingLikeDTO;
import com.icia.gangcamping.dto.CampingLikeDetailDTO;
import com.icia.gangcamping.entity.CampingEntity;
import com.icia.gangcamping.entity.CampingLikeEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.repository.CampingLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


}
