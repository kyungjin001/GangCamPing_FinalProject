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
@Table(name = "campingPay_table")
public class CampingPayEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="campingPayId")
    private Long campingPayId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingId")
    private CampingEntity campingEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private RoomEntity roomEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private BookEntity bookEntity;
    @Column
    @NotNull
    private LocalDateTime campingPayDate;
    @Column
    @NotNull
    private int campingPayPrice;
    @Column
    @NotNull
    private String campingPaySelect;
}
