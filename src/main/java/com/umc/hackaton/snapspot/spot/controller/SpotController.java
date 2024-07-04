package com.umc.hackaton.snapspot.spot.controller;

import com.umc.hackaton.snapspot.spot.dto.SpotRequestDto;
import com.umc.hackaton.snapspot.spot.dto.SpotResponseDto;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.spot.service.SpotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/spots")
public class SpotController {


    private final SpotService spotService;

    @PostMapping
    public ResponseEntity<?> upload(@RequestBody SpotRequestDto dto, MultipartFile file) {
        try {
            Spot spot = spotService.upload(dto, file);
            return ResponseEntity.ok().body(spot);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("스팟 업로드에 실패하였습니다.");
        }
    }

    @GetMapping("/list/{spotId}")
    public Spot getSpotById(@PathVariable Long spotId) {
        return spotService.getSpotById(spotId);

    }

    @GetMapping("/{spotId}")
    public ResponseEntity<?> showSpot(
            @PathVariable("spotId") Long spotId
    ) {
        try {
            Spot spot = spotService.getSpot(spotId);
            return ResponseEntity.ok().body(spot);
        } catch (Exception e) {
            log.info("스팟 조회에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("스팟 조회에 실패하였습니다.");
        }
    }

    @DeleteMapping("/{spotId}")
    public ResponseEntity<?> deleteSpot(
            @PathVariable("spotId") Long spotId
    ) {
        try {
            spotService.deleteSpot(spotId);
            return ResponseEntity.ok().body("success");
        } catch (Exception e) {
            log.info("스팟 삭제에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("스팟 삭제에 실패하였습니다.");
        }
    }

    @PatchMapping("/{spotId}")
    public ResponseEntity<?> patchSpot(
            @PathVariable("spotId") Long spotId,
            @RequestBody SpotRequestDto dto
    ) {
        try {
            Spot spot = spotService.updateSpot(spotId, dto);
            return ResponseEntity.ok().body(spot);
        } catch (Exception e) {
            log.info("스팟 수정에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("스팟 수정에 실패하였습니다.");
        }
    }


    @GetMapping("list")
    public ResponseEntity<List<SpotResponseDto>> readNearSpotList(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude){
        return ResponseEntity.ok(spotService.readNearSpotList(latitude, longitude));
    }

    @GetMapping("list/category")
    public ResponseEntity<List<SpotResponseDto>> readCategoryNearSpotList(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude, @RequestParam("categoryId") Long categoryId){
        List<SpotResponseDto> list = spotService.readNearSpotList(latitude, longitude);
        return ResponseEntity.ok(spotService.readCategoryNearSpotList(list, categoryId));
    }
}
