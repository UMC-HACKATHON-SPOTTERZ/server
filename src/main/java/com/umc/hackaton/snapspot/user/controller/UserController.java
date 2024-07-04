package com.umc.hackaton.snapspot.user.controller;

import com.umc.hackaton.snapspot.user.dto.request.ImageUploadDto;
import com.umc.hackaton.snapspot.user.dto.request.LoginDto;
import com.umc.hackaton.snapspot.user.dto.request.UserRequestDto;
import com.umc.hackaton.snapspot.user.dto.response.UserResponseDto;
import com.umc.hackaton.snapspot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserRequestDto dto) {
        try {
            userService.signUp(dto);
            return ResponseEntity.ok().body("회원가입 성공.");
        } catch (Exception e) {
            log.info("회원가입에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입에 실패하였습니다.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto) {
        try {
            UserResponseDto responseDto = userService.login(dto);
            return ResponseEntity.ok( responseDto);
        } catch (Exception e) {
            log.info("로그인에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그인에 실패하였습니다.");
        }
    }

    @PostMapping("/image-uploads")
    public ResponseEntity<?> imageUploads(@RequestBody ImageUploadDto dto) {
        try {
            userService.imageUploads(dto);
            return ResponseEntity.ok().body("이미지 업로드 성공.");
        } catch (Exception e) {
            log.info("이미지 업로드에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미지 업로드에 실패하였습니다.");
        }
    }
}
