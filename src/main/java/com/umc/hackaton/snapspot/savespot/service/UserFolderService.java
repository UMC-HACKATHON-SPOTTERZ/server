package com.umc.hackaton.snapspot.savespot.service;

import com.umc.hackaton.snapspot.savespot.dto.UserFolderRequestDto;
import com.umc.hackaton.snapspot.savespot.entity.UserFolder;
import com.umc.hackaton.snapspot.savespot.repository.UserFolderRepository;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFolderService {
    private final UserFolderRepository userFolderRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(UserFolderRequestDto userFolder) {
        User user = userRepository.findById(userFolder.getUserId()).orElse(null);
        userFolderRepository.save(userFolder.toEntity(user));
    }

    public void delete(Long folderId) {
        UserFolder userFolder = userFolderRepository.findById(folderId).orElse(null);
        userFolder.setIsDeleted(true);
        userFolderRepository.save(userFolder);
    }

    public UserFolder update(Long folderId, UserFolderRequestDto userFolderRequestDto) {
        UserFolder userFolder = userFolderRepository.findById(folderId).orElse(null);
        userFolder.setFolderName(userFolderRequestDto.getFolderName());
        userFolderRepository.save(userFolder);
        return userFolderRepository.findById(folderId).get();
    }

    public List<UserFolder> getAllFoldersByUserId(Long userId) {
        return userFolderRepository.findAllByUserIdAndIsDeletedFalse(userId);
    }
}