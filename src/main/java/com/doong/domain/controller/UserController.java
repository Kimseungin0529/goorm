package com.doong.domain.controller;

import com.doong.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller @Slf4j
public class UserController {
    @GetMapping("/user/login")
    public String showLoginForm(Model model) {
        // 빈 사용자 객체를 뷰에 전달합니다.
        model.addAttribute("user", new User());
        log.info("/user/login GET 호출");
        return "login";  // login.html을 의미합니다.
    }
    @PostMapping("/user/login")
    public String processLogin(@ModelAttribute User user, Model model) {
        User validUser = User.isValidUser(user);
        log.info(user.getEmail());
        log.info(user.getPassword());
        if (validUser != null) {
            // 유효한 사용자일 경우, 성공 페이지로 이동하고 사용자 정보를 전달합니다.
            model.addAttribute("user", validUser);
            log.info("로그인 성공");
            return "loginSuccess";  // loginSuccess.html을 의미합니다.
        } else {
            // 유효하지 않으면 다시 로그인 폼을 보여줍니다.
            model.addAttribute("loginError", true);
            log.info("로그인 실패");
            return "redirect:/user/login";  // 다시 login.html로 돌아갑니다.
        }
    }
}
