package com.icia.gangcamping.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "bookList_table")
public class BookListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookListId")
    private Long bookListId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private RoomEntity roomEntity;
    @Column
    @NotNull
    private LocalDateTime bookListDate;

}
