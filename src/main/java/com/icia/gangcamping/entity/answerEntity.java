package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "answer_table")
public class answerEntity {
    @Id
    @GeneratedValue
    @Column(name = "answerId")
    private Long answerId;
    @Column
    @NotNull
    private Long questionId;
    @Column
    @NotNull
    private String answerContents;
}
