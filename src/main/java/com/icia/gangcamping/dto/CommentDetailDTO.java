package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.CartEntity;
import com.icia.gangcamping.entity.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CommentDetailDTO {


    private Long questionId;
    private Long memberId;
    private Long productId;
    private String commentWriter;
    private String questionContents;
    private LocalDateTime commentTime;



    public static CommentDetailDTO toCommentDetailDTO(QuestionEntity questionEntity) {
        System.out.println(questionEntity.getMemberEntity().getMemberEmail());
        System.out.println(questionEntity.getMemberEntity().getMemberId());
        CommentDetailDTO commentDetailDTO = new CommentDetailDTO();
        commentDetailDTO.setQuestionId(questionEntity.getQuestionId());
//        commentDetailDTO.setMemberId(questionEntity.getMemberEntity().getMemberId());
        commentDetailDTO.setProductId(questionEntity.getProductEntity().getProductId());
        commentDetailDTO.setCommentWriter(questionEntity.getMemberEntity().getMemberEmail());
        commentDetailDTO.setQuestionContents(questionEntity.getQuestionContents());
        if(questionEntity.getUpdateTime()==null){
            commentDetailDTO.setCommentTime(questionEntity.getCreateTime());
        }else {
            commentDetailDTO.setCommentTime(questionEntity.getUpdateTime());
        }
        return commentDetailDTO;
    }






}