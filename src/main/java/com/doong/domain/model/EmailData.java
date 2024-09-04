package com.doong.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class EmailData {
    private String toAddress;
    private String subject;
    private String content;

    @Builder
    public EmailData(String toAddress, String subject, String content) {
        this.toAddress = toAddress;
        this.subject = subject;
        this.content = content;
    }

    @Override
    public String toString() {
        return "EmailData{" +
                "toAddress='" + toAddress + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
