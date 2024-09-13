package com.doong.exp.program0912;

import com.doong.exp.program0912.domain.user.UserController;
import com.doong.exp.program0912.domain.user.UserDto;
import com.doong.exp.program0912.domain.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    UserController userController;
    @MockBean
    UserService userService;


    @Test
    @DisplayName("사용자 식별자 ID로 사용자를 조회한다.")
    void findUser() throws Exception {
        //given
        Long userId = 1L;
        UserDto userDto = UserDto.builder()
                .username("username")
                .password("password")
                .build();
        Mockito.when(userService.findUserById(userId))
                .thenReturn(userDto);

        //when & then
        mockMvc.perform(
                MockMvcRequestBuilders.get("/users/1")
                        .content(objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
                /*.andExpect(jsonPath("$.data.username").value("username"))
                .andExpect(jsonPath("$.data.password").value("password"));*/


    }
}