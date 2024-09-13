package com.doong.exp.program0912;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserDto {
    private String username;
    private String password;

}
