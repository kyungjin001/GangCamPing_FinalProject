package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "book_table")
public class bookEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Long bookId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private memberEntity memberEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingId")
    private campingEntity campingEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private roomEntity roomEntity;
    @Column
    @NotNull
    private LocalDateTime bookCheckIn;
    @Column
    @NotNull
    private LocalDateTime bookCheckOut;
    @Column
    @NotNull
    private String bookPeriod;
    @Column
    @NotNull
    private int bookPrice;

    @OneToMany(mappedBy = "bookEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<campingPayEntity> campingPayEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "bookEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<campingSaleEntity> campingSaleEntityList = new ArrayList<>();


}
