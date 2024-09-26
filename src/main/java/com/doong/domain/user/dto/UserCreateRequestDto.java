package com.doong.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class UserCreateRequestDto {
    private String email;
    private String password;
    private String nickname;
}
