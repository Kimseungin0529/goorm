package com.doong.exp.program0912;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(UserDto dto){
        URI uri = URI.create("/users/" + userService.createUser(dto));
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findUser(@PathVariable("id") Long userId){
        return ResponseEntity.ok(userService.findUserById(userId));
    }
}
