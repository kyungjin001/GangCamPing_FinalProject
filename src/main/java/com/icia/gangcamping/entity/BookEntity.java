package com.icia.gangcamping.entity;

import com.icia.gangcamping.dto.BookSaveDTO;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "book_table")
public class BookEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Long bookId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingId")
    private CampingEntity campingEntity;
    @Column
    @NotNull
    private Date bookCheckIn;
    @Column
    @NotNull
    private Date bookCheckOut;
    @Column
    @NotNull
    private String bookName;
    @Column
    @NotNull
    private int bookPrice;

    @OneToMany(mappedBy = "bookEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CampingPayEntity> campingPayEntityList = new ArrayList<>();
    @OneToMany(mappedBy = "bookEntity",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<CampingSaleEntity> campingSaleEntityList = new ArrayList<>();

    public static BookEntity toBookSave(BookSaveDTO bookSaveDTO, MemberEntity memberEntity, CampingEntity campingEntity) {

        BookEntity bookEntity = new BookEntity();

        bookEntity.setBookName(bookSaveDTO.getBookName());
        bookEntity.setBookCheckIn(bookSaveDTO.getBookCheckIn());
        bookEntity.setBookCheckOut(bookSaveDTO.getBookCheckOut());
        bookEntity.setBookPrice(bookSaveDTO.getBookPrice());
        bookEntity.setMemberEntity(memberEntity);
        bookEntity.setCampingEntity(campingEntity);
        return bookEntity;
    }
}
