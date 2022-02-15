package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
