package com.umc.hackaton.snapspot.savespot.repository;

import com.umc.hackaton.snapspot.savespot.entity.UserFolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFolderRepository extends JpaRepository<UserFolder, Long> {
    List<UserFolder> findAllByUserIdAndIsDeletedFalse(Long userId);
}
