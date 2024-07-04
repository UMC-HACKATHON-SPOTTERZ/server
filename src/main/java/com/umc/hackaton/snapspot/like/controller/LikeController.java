package com.umc.hackaton.snapspot.like.controller;

import com.umc.hackaton.snapspot.like.dto.LikeDto;
import com.umc.hackaton.snapspot.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/spots/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("")
    public ResponseEntity<LikeDto.ResponseDto> registerLike(@RequestBody LikeDto.RequestDto likeDto){
        return ResponseEntity.ok(likeService.registerLike(likeDto));
    }


    @DeleteMapping("")
    public ResponseEntity<LikeDto.ResponseDto> deleteLike(@RequestBody LikeDto.RequestDto likeDto){
        return ResponseEntity.ok(likeService.deleteLike(likeDto));
    }

}
