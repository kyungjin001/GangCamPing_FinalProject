package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.MailCodeDTO;
import com.icia.gangcamping.dto.MailCodeDetailDTO;
import com.icia.gangcamping.entity.MailEntity;
import com.icia.gangcamping.entity.MemberEntity;
import com.icia.gangcamping.repository.MailRepository;
import com.icia.gangcamping.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor

public class MailServiceImpl implements MailService {

    private final MailRepository mar;
    private final MemberRepository mr;
    private JavaMailSender javaMailSender;

    @Override
    public Long mailSend(MailCodeDTO mailCodeDTO) {
        Random random = new Random(); // 난수 생성
        String key=""; // 인증번호
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailCodeDTO.getMemberEmail());

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
        MemberEntity memberEntity = mr.findByMemberEmail(mailCodeDTO.getMemberEmail());
        MailEntity mailEntity = MailEntity.saveMailCode(mailCodeDTO, memberEntity);

        return mar.save(mailEntity).getId();
        // return key;
    }

    @Override
    public String findByEmailCode(String emailCode) {
        MailEntity mailEntity = mar.findByEmailCode(emailCode);

        if(mailEntity != null){
            return "ok";
        }else{
            return "no";
        }

    }

    @Override
    public MailCodeDetailDTO findByMemberEmailAndEmailCode(String memberEmail, String emailCode) {
        MailEntity mailEntity = mar.findByMemberEmailAndEmailCode(memberEmail,emailCode);
        MailCodeDetailDTO mailCodeDetailDTO = MailCodeDetailDTO.toMailCodeDetailDTO(mailEntity);
        return mailCodeDetailDTO;
    }

}

