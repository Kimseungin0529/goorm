package com.doong.domain.controller;

import com.doong.domain.model.EmailData;
import com.doong.domain.service.EmailServiceClient;
import jakarta.validation.constraints.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/email")
public class EmailController {

    @PostMapping("/send")
    @ResponseBody
    public String sendEmail(){
        EmailServiceClient client = new EmailServiceClient();
        EmailData emailData = generateEmailRequest();
        client.sendEmail(emailData);

        return "success";
    }

    public EmailData generateEmailRequest(){
        return EmailData.builder() // 테스트 이메일 객체 생성
                .toAddress("test@naver.com")
                .subject("Test")
                .content("This is a test email")
                .build();
    }
}
