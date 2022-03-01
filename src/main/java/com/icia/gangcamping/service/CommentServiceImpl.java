package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CommentDetailDTO;
import com.icia.gangcamping.dto.CommentSaveDTO;
import com.icia.gangcamping.dto.GoodsDetailDTO;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.entity.ProductEntity;
import com.icia.gangcamping.entity.QuestionEntity;
import com.icia.gangcamping.repository.MemberRepository;
import com.icia.gangcamping.repository.ProductRepositroy;
import com.icia.gangcamping.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final MemberRepository mr;
    private final ProductRepositroy pr;
    private final QuestionRepository qr;


    @Override
    public Long save(CommentSaveDTO commentSaveDTO) {
        ProductEntity productEntity = pr.findById(commentSaveDTO.getProductId()).get();
        MemberEntity memberEntity = mr.findByMemberEmail(commentSaveDTO.getCommentWriter());
        QuestionEntity questionEntity = QuestionEntity.toSaveEntity(commentSaveDTO,memberEntity,productEntity);
        return qr.save(questionEntity).getQuestionId();
    }

    @Override
    public List<CommentDetailDTO> findAll(Long productId) {
        ProductEntity productEntity = pr.findById(productId).get();
        List<QuestionEntity> questionEntityList = productEntity.getQuestionEntityList();
        List<CommentDetailDTO> commentList = new ArrayList<>();
        for (QuestionEntity q : questionEntityList){
            CommentDetailDTO commentDetailDTO = CommentDetailDTO.toCommentDetailDTO(q);
            commentList.add(commentDetailDTO);
        }
        return commentList;
    }

    @Override
    public void deleteById(Long questionId) {
        qr.deleteById(questionId);
    }

    @Override
    public List<CommentDetailDTO> findAll1() {
        List<QuestionEntity> questionEntityList = qr.findAll();
        List<CommentDetailDTO> commentList = new ArrayList<>();
        for (QuestionEntity q : questionEntityList)
        {
            commentList.add(CommentDetailDTO.toCommentDetailDTO(q )); //한줄로 가능

        }
        return commentList;


    }
}
