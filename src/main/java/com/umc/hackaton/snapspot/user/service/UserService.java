package com.umc.hackaton.snapspot.user.service;

import com.umc.hackaton.snapspot.user.dto.LoginDto;
import com.umc.hackaton.snapspot.user.dto.UserRequestDto;
import com.umc.hackaton.snapspot.user.dto.UserResponseDto;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public void signUp(UserRequestDto dto) {
        User user = dto.toEntity(encoder);
        userRepository.save(user);
    }

    @Transactional
    public UserResponseDto login(LoginDto dto) {
        Optional<User> loginuser = userRepository.findByUsername(dto.getUsername());
        if (loginuser.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }

        if (!encoder.matches(dto.getPassword(), loginuser.get().getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return UserResponseDto.builder()
                .id(loginuser.get().getId())
                .username(loginuser.get().getUsername())
                .nickname(loginuser.get().getNickname())
                .profileImg(loginuser.get().getProfileImg())
                .build();

    }
}

