package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.MailCodeDTO;
import com.icia.gangcamping.dto.MailDTO;
import com.icia.gangcamping.entity.MailEntity;
import com.icia.gangcamping.repository.MailRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor

public class MailServiceImpl implements MailService {

    private final MailRepository mar;
    private JavaMailSender javaMailSender;

    @Override
    public Long mailSend(MailDTO mailDTO, MailCodeDTO mailCodeDTO) {
        Random random = new Random(); // 난수 생성
        String key=""; // 인증번호
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDTO.getMemberEmail());

        for(int i =0; i<3; i++){
            int index = random.nextInt(25)+65;
            key+=(char)index;
        }
        int numIndex = random.nextInt(9999)+1000;

        key += numIndex;
        message.setSubject("인증번호 입력을 위한 메일 전송");
        message.setText("인증번호 : " + key);
        //message.setText(key);
        /*message.setSubject(mailDTO.getTitle());
        message.setText(mailDTO.getMessage());*/
        javaMailSender.send(message);

        mailCodeDTO.setEmailCode(key);
        MailEntity mailEntity = MailEntity.saveMailCode(mailCodeDTO);

        return mar.save(mailEntity).getId();
        // return key;
    }
    }

