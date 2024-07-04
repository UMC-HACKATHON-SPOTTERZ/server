package com.umc.hackaton.snapspot.user.service;

import com.umc.hackaton.snapspot.user.dto.UserRequestDto;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public void signUp(UserRequestDto dto) {

//        Optional<User> existingUser = userRepository.findByUserId(dto.getUserId());
//        if (existingUser.isPresent()) {
//            User user = existingUser.get();
//        } else {
        User user = dto.toEntity(encoder);
        userRepository.save(user);
    }
}

