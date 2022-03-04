package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.ChattingSaveDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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


    public static ChattingEntity toSaveEntity(ChattingSaveDTO chattingSaveDTO, MemberEntity memberEntity){
        ChattingEntity chat = new ChattingEntity();
        chat.setChattingContents(chattingSaveDTO.getChattingContents());
        chat.setChattingDate(chattingSaveDTO.getChattingDate());
        chat.setChattingFileName(chattingSaveDTO.getChattingFileName());
        chat.setMemberEntity(memberEntity);
        return chat;

    }


}
