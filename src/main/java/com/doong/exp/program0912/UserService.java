package com.doong.exp.program0912;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public Long createUser(UserDto dto){
        User user = User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();

        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @Transactional(readOnly = true)
    public UserDto findUserById(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 입니다."));
        return UserDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
