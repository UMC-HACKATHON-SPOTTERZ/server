package com.umc.hackaton.snapspot.savespot.controller;

import com.umc.hackaton.snapspot.savespot.dto.SpotSaveReqeustDto;
import com.umc.hackaton.snapspot.savespot.dto.SpotSaveResponseDto;
import com.umc.hackaton.snapspot.savespot.service.SpotSaveService;
import com.umc.hackaton.snapspot.savespot.service.UserFolderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/savespot")
@Slf4j
public class SaveSpotController {

    private final SpotSaveService spotSaveService;
    private final UserFolderService userFolderService;

    @PostMapping
    public ResponseEntity<?> saveSpotSave(@RequestBody SpotSaveReqeustDto spotSaveRequestDto) {
        try {
            spotSaveService.save(spotSaveRequestDto);
            return ResponseEntity.ok().body("Userfolder에 Spot 저장 성공");
        } catch (Exception e) {
            log.error("스팟 저장에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Userfolder에 Spot 저장에 실패하였습니다.");
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteSpotSave(@RequestParam Long spotSaveId) {
        try {
            spotSaveService.delete(spotSaveId);
            return ResponseEntity.ok().body("Userfolder에 Spot 삭제 성공");
        } catch (Exception e) {
            log.info("스팟 삭제에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Userfolder에 Spot 삭제에 실패하였습니다.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSpotSave(@PathVariable("id") Long id) {
        try {
            SpotSaveResponseDto spotSaveList = spotSaveService.getSpotsByFolderId(id);
            return ResponseEntity.ok().body(spotSaveList);
        } catch (Exception e) {
            log.info("스팟 조회에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Userfolder에 Spot 조회에 실패하였습니다.");
        }
    }
}
