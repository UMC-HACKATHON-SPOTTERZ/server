package com.umc.hackaton.snapspot.savespot.service;

import com.umc.hackaton.snapspot.savespot.dto.UserFolderRequestDto;
import com.umc.hackaton.snapspot.savespot.entity.UserFolder;
import com.umc.hackaton.snapspot.savespot.repository.UserFolderRepository;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserFolderService {
    private final UserFolderRepository userFolderRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(UserFolderRequestDto userFolder) {
        User user = userRepository.findByUserId(userFolder.getUserId().toString()).orElse(null);
        userFolderRepository.save(userFolder.toEntity(user));
    }
}
