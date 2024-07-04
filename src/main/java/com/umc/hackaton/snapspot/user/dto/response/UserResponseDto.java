package com.umc.hackaton.snapspot.user.dto.response;

import com.umc.hackaton.snapspot.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {
    private Long id;
    private String username;

    public static UserResponseDto fromEntity(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
