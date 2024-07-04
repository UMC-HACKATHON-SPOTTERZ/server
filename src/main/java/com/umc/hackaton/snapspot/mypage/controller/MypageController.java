package com.umc.hackaton.snapspot.mypage.controller;

import com.umc.hackaton.snapspot.mypage.dto.MypageDto;
import com.umc.hackaton.snapspot.mypage.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/mypage")
public class MypageController {
    final private MypageService mypageService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<MypageDto.MySptDto>> readAllMySpot(@PathVariable Long userId){
        return ResponseEntity.ok(mypageService.readAllMySpot(userId));
    }


    @GetMapping("/{userId}/profile")
    public ResponseEntity<MypageDto.MyProfile> readMyProfile(@PathVariable Long userId){
        return ResponseEntity.ok(mypageService.readMyProfile(userId));
    }
}
