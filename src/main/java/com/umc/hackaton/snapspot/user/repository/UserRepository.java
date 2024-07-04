package com.umc.hackaton.snapspot.user.repository;

import com.umc.hackaton.snapspot.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    User findUserById(Long id);
}
