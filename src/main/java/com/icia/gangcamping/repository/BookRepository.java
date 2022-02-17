package com.icia.gangcamping.repository;

import com.icia.gangcamping.entity.bookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<bookEntity, Long> {

}
