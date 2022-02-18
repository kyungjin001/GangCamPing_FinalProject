package com.icia.gangcamping.service;

import com.icia.gangcamping.dto.MailCodeDTO;
import com.icia.gangcamping.dto.MailDTO;

public interface MailService {
    Long mailSend(MailDTO mailDTO, MailCodeDTO mailCodeDTO);
}
