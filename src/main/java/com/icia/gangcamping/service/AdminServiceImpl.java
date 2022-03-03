package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.CommentDetailDTO;
import com.icia.gangcamping.entity.QuestionEntity;
import com.icia.gangcamping.repository.ProductRepositroy;
import com.icia.gangcamping.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ProductRepositroy pr;
    private final QuestionRepository qr;



    @Override
    public void deleteById(Long productId) {
        pr.deleteById(productId);
    }


    @Override
    public List<CommentDetailDTO> findAll1() {
        List<QuestionEntity> questionEntityList = qr.findAll();
        List<CommentDetailDTO> commentList = new ArrayList<>();
        for (QuestionEntity q : questionEntityList)
        {
            commentList.add(CommentDetailDTO.toCommentDetailDTO(q )); //한줄로 가능

        }
        return commentList;


    }

}
