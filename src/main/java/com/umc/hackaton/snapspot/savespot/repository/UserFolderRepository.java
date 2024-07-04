package com.umc.hackaton.snapspot.savespot.repository;

import com.umc.hackaton.snapspot.savespot.entity.UserFolder;
import com.umc.hackaton.snapspot.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFolderRepository extends JpaRepository<UserFolder, Long> {
    List<UserFolder> findAllByUserIdAndIsDeletedFalse(Long userId);
    UserFolder findByUser(User user);
}
