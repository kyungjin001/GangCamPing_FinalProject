package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.CommentSaveDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "question_table")
public class QuestionEntity extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "questionId")
    private Long questionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private ProductEntity productEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;
    @Column
    @NotNull
    private  String questionContents;
    @Column
    @NotNull
    private boolean answerCheck;

    @OneToOne(mappedBy = "questionEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private AnswerEntity answerEntity;


    public static QuestionEntity toSaveEntity(CommentSaveDTO commentSaveDTO,MemberEntity memberEntity,ProductEntity productEntity) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setMemberEntity(memberEntity);
        questionEntity.setProductEntity(productEntity);
        questionEntity.setQuestionContents(commentSaveDTO.getQuestionContents());
        return questionEntity;
    }







}
