package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.MailCodeDTO;
import com.icia.gangcamping.dto.MailCodeDetailDTO;

public interface MailService {
    Long mailSend(MailCodeDTO mailCodeDTO);

    String findByEmailCode(String emailCode);

    MailCodeDetailDTO findByMemberEmailAndEmailCode(String memberEmail, String emailCode);

    String findByMail(String emailCode);
}
