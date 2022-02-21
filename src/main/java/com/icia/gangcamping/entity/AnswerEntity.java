package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "answer_table")
public class AnswerEntity {
    @Id
    @GeneratedValue
    @Column(name = "answerId")
    private Long answerId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private QuestionEntity questionEntity;
    @Column
    @NotNull
    private String answerContents;
}