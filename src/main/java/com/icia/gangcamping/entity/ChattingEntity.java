package com.icia.gangcamping.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "chatting_table")
public class ChattingEntity extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "chattingId")
    private Long chattingId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;
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
