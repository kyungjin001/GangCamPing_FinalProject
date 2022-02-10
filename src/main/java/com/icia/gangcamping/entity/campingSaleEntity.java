package com.icia.gangcamping.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "campingSale_table")
public class campingSaleEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="campingSaleId")
    private Long campingSaleId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private bookEntity bookEntity;
    @Column
    @NotNull
    private LocalDateTime campingSaleDate;
    @Column
    @NotNull
    private int campingSalePrice;
}
