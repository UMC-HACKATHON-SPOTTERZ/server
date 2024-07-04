package com.umc.hackaton.snapspot.user.dto;

import com.umc.hackaton.snapspot.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
public class UserRequestDto {
    private String username;
    private String password;
    private String nickname;

    @Builder
    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .nickname(nickname)
                .profileImg("default")
                .build();
    }
}
