package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "board_table")
public class campingLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="campingLikeId")
    private Long campingLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingId")
    private campingEntity campingEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private memberEntity memberEntity;

    @Column
    @NotNull
    private LocalDateTime campingLikeDate;

}
