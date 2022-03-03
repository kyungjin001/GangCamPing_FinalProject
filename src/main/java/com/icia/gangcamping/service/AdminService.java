package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CommentDetailDTO;

import java.util.List;

public interface AdminService {


    void deleteById(Long productId);

    List<CommentDetailDTO> findAll1();

}
