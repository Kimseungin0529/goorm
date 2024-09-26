package com.doong.domain.user.controller;

import com.doong.domain.user.dto.UserCreateRequestDto;
import com.doong.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/sign-up")
    public String signUp(){
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signup(@ModelAttribute UserCreateRequestDto request) {
        userService.registerNewUser(request);
        return "redirect:/login";  // 회원가입 후 로그인 페이지로 리다이렉트
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
