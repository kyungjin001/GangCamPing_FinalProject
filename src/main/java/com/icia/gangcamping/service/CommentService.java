package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.AnswerDetailDTO;
import com.icia.gangcamping.dto.AnswerSaveDTO;
import com.icia.gangcamping.dto.CommentDetailDTO;
import com.icia.gangcamping.dto.CommentSaveDTO;

import java.text.ParseException;
import java.util.List;

public interface CommentService {
    Long save(CommentSaveDTO commentSaveDTO);

    List<CommentDetailDTO> findAll(Long productId) throws ParseException;

    void deleteById(Long questionId);

    List<CommentDetailDTO> findAll1() ;

    Long save1(AnswerSaveDTO answerSaveDTO);

    List<AnswerDetailDTO> findAll2(Long productId);

}
