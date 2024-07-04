package com.umc.hackaton.snapspot.savespot.dto;

import com.umc.hackaton.snapspot.savespot.entity.UserFolder;
import com.umc.hackaton.snapspot.user.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserFolderRequestDto {
    @NotNull private Long userId;
    @NotNull private String folderName;

    @Builder
    public UserFolder toEntity(User user){
        return UserFolder.builder()
                .user(user)
                .folderName(folderName)
                .build();
    }
}
