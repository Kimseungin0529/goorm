package com.doong.domain.service;

import com.doong.domain.model.EmailData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailServiceClient {
    public void sendEmail(EmailData email){
        // 이메일 발송 로직
        log.info(email.toString());
    }
}
