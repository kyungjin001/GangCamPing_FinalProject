package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.ChattingSaveDTO;
import com.icia.gangcamping.dto.CommentDetailDTO;
import com.icia.gangcamping.dto.CommentSaveDTO;
import com.icia.gangcamping.entity.ChattingEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;
import com.icia.gangcamping.entity.QuestionEntity;
import com.icia.gangcamping.repository.ChattingRepository;
import com.icia.gangcamping.repository.MemberRepository;
import com.icia.gangcamping.repository.ProductRepositroy;
import com.icia.gangcamping.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChattingServiceImpl implements ChattingService{

    private final MemberRepository mr;
    private final ProductRepositroy pr;
    private final ChattingRepository hr;
    private  final HttpSession session;


    @Override
    public Long save(ChattingSaveDTO chattingSaveDTO) {
        MemberEntity memberEntity = mr.findByMemberEmail((String) session.getAttribute("loginEmail"));
        ChattingEntity chattingEntity = ChattingEntity.toSaveEntity(chattingSaveDTO,memberEntity);
        return hr.save(chattingEntity).getChattingId();
    }
}
