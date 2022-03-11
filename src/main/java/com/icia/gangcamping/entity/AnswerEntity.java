package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.AnswerSaveDTO;
import com.icia.gangcamping.dto.CommentSaveDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "answer_table")
public class AnswerEntity extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "answerId")
    private Long answerId;
//    @OneToOne(fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private QuestionEntity questionEntity;
    @Column
    @NotNull
    private String answerContents;


    public static AnswerEntity toSaveEntity(AnswerSaveDTO answerSaveDTO, QuestionEntity questionEntity) {
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setQuestionEntity(questionEntity);
        answerEntity.setAnswerContents(answerSaveDTO.getAnswerContents());
        return answerEntity;
    }


}
