package com.umc.hackaton.snapspot.spot.controller;

import com.umc.hackaton.snapspot.spot.dto.SpotRequestDto;
import com.umc.hackaton.snapspot.spot.service.SpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/spots")
public class SpotController {


    private final SpotService spotService;

    @PostMapping
    public ResponseEntity<?> upload(@RequestBody SpotRequestDto dto){
        try {
            spotService.upload(dto);
            return ResponseEntity.ok().body("스팟 업로드 성공.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("스팟 업로드에 실패하였습니다.");
        }
    }
}
