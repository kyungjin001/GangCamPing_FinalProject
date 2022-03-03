package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.ChattingSaveDTO;
import com.icia.gangcamping.dto.CommentDetailDTO;
import com.icia.gangcamping.dto.CommentSaveDTO;

import java.util.List;

public interface ChattingService {

    Long save(ChattingSaveDTO chattingSaveDTO);
}
