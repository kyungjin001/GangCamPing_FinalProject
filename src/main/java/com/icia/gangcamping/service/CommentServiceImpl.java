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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    //상품문의
    @Override
    public List<CommentDetailDTO> findAll(Long productId) throws ParseException {
        ProductEntity productEntity = pr.findById(productId).get();
        List<QuestionEntity> questionEntityList = productEntity.getQuestionEntityList();
        List<CommentDetailDTO> commentList = new ArrayList<>();
        for (QuestionEntity q : questionEntityList){
            CommentDetailDTO commentDetailDTO = CommentDetailDTO.toCommentDetailDTO(q);
            LocalDateTime commentT =q.getCreateTime();

            String date1 = java.sql.Timestamp.valueOf(commentT).toString().substring(0,19);
//

            commentDetailDTO.setCommentT(date1);
            System.out.println(commentDetailDTO);
            commentList.add(commentDetailDTO); //한줄로 가능
        }
        return commentList;
    }

    @Override
    public void deleteById(Long questionId) {
        qr.deleteById(questionId);
    }


    //관리자 상품문의리스트
    @Override
    public List<CommentDetailDTO> findAll1()  {
        List<QuestionEntity> questionEntityList = qr.findAll();
        List<CommentDetailDTO> commentList = new ArrayList<>();
        for (QuestionEntity q : questionEntityList)
        {

            commentList.add(CommentDetailDTO.toCommentDetailDTO(q)); //한줄로 가능


        }
        return commentList;


    }
}
