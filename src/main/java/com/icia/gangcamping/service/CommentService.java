package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CommentDetailDTO;
import com.icia.gangcamping.dto.CommentSaveDTO;

import java.util.List;

public interface CommentService {
    Long save(CommentSaveDTO commentSaveDTO);

    List<CommentDetailDTO> findAll(Long productId);

    void deleteById(Long questionId);
}
