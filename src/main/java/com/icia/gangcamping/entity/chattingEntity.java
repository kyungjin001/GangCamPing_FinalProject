package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "chatting_table")
public class chattingEntity extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "chattingId")
    private Long chattingId;
    @Column
    private Long memberId;
    @Column
    @NotNull
    private LocalDateTime chattingDate;
    @Column
    @NotNull
    private String chattingContents;
    @Column
    @NotNull
    private String chattingFileName;
}
