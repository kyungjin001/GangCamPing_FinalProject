package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "question_table")
public class questionEntity {
    @Id
    @GeneratedValue
    @Column(name = "questionId")
    private Long questionId;
    @Column
    @NotNull
    private Long productId;
    @Column
    @NotNull
    private Long memberId;
    @Column
    @NotNull
    private  String questionContents;
    @Column
    @NotNull
    private boolean answerCheck;


}
