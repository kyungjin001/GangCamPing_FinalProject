package com.icia.gangcamping.dto;


import com.icia.gangcamping.entity.AnswerEntity;
import com.icia.gangcamping.entity.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AnswerDetailDTO {


    private Long answerId;
    private Long questionId;
    private String answerContents;
    private Long memberId;
    private Long productId;
    private String commentWriter;
    private String questionContents;
    private LocalDateTime commentTime;
    private String memberEmail;
    private String productName;
    private String commentT;



    public static AnswerDetailDTO toAnswerDetailDTO(AnswerEntity answer){
        AnswerDetailDTO answerDetailDTO = new AnswerDetailDTO();
        answerDetailDTO.setAnswerId(answer.getAnswerId());
        answerDetailDTO.setProductId(answer.getQuestionEntity().getProductEntity().getProductId());
        answerDetailDTO.setMemberId(answer.getQuestionEntity().getMemberEntity().getMemberId());
        answerDetailDTO.setQuestionId(answer.getQuestionEntity().getQuestionId());
        answerDetailDTO.setAnswerContents(answer.getAnswerContents());
        answerDetailDTO.setCommentWriter(answer.getQuestionEntity().getMemberEntity().getMemberEmail());
        answerDetailDTO.setQuestionContents(answer.getQuestionEntity().getQuestionContents());
//        answerDetailDTO.setCommentT(answer.getQuestionEntity().getCreateTime());
        answerDetailDTO.setProductName(answer.getQuestionEntity().getProductEntity().getProductName());
        if(answer.getUpdateTime()==null){
            answerDetailDTO.setCommentTime(answer.getCreateTime());
        }else {
            answerDetailDTO.setCommentTime(answer.getUpdateTime());
        }
        return answerDetailDTO;
    }


}
