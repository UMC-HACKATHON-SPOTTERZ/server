package com.umc.hackaton.snapspot.savespot.controller;

import com.umc.hackaton.snapspot.savespot.dto.UserFolderRequestDto;
import com.umc.hackaton.snapspot.savespot.entity.UserFolder;
import com.umc.hackaton.snapspot.savespot.service.UserFolderService;
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
@RequestMapping("/api/v1/folders")
public class UserFolderController {
    private final UserFolderService userFolderService;
    private final UserService userService;

    //TODO FolderResponseDTO 사용 여부 확인
    @PostMapping("/")
    public ResponseEntity<?> createFolder(@RequestBody UserFolderRequestDto folder) {
        try {
            userFolderService.save(folder);
            return ResponseEntity.ok().body(folder);
        } catch (Exception e){
            log.info("유저 폴더 생성에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("폴더 생성에 실패하였습니다.");
        }
    }
}
