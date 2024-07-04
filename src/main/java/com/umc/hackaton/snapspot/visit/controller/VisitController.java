package com.umc.hackaton.snapspot.visit.controller;

import com.umc.hackaton.snapspot.visit.dto.VisitRequestDto;
import com.umc.hackaton.snapspot.visit.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/visit")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @PostMapping
    public ResponseEntity<?> saveVisit(@RequestBody VisitRequestDto dto) {
        try {
            visitService.saveVisit(dto);
            return ResponseEntity.ok().body("스팟 방문 저장 성공.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("스팟 방문 저장에 실패하였습니다.");
        }
    }
}
