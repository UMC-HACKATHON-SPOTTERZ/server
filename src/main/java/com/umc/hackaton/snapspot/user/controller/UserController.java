package com.umc.hackaton.snapspot.user.controller;

import com.umc.hackaton.snapspot.user.dto.UserRequestDto;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import com.umc.hackaton.snapspot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(UserRequestDto dto) {
        try {
            userService.signUp(dto);
            return ResponseEntity.ok().body("회원가입 성공.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입에 실패하였습니다.");
        }
    }
}
