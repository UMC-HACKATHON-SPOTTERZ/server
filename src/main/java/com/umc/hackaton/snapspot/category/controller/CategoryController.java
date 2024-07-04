package com.umc.hackaton.snapspot.category.controller;

import com.umc.hackaton.snapspot.category.dto.CategoryRequestDto;
import com.umc.hackaton.snapspot.category.entity.Category;
import com.umc.hackaton.snapspot.category.service.CategoryService;
import com.umc.hackaton.snapspot.savespot.dto.UserFolderRequestDto;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequestDto category) {
        try {
            categoryService.save(category);
            return ResponseEntity.ok().body(category);
        } catch (Exception e){
            log.info("카테고리 생성에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("카테고리 생성에 실패하였습니다.");
        }
    }


    @GetMapping("/")
    public ResponseEntity<?> showAllCategories() {
        try {
            List<Category> categories = categoryService.showAll();
            return ResponseEntity.ok().body(categories);
        } catch (Exception e){
            log.info("카테고리 리스트 조회에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("카테고리 리스트 조회에 실패하였습니다.");
        }
    }

    @GetMapping("/spots")
    public ResponseEntity<?> showSpotsByCategoryId(
            @RequestParam List<Long> categoryIds
    ) {
        try {
            List<Spot> spots = categoryService.showSpotsByCategoryIds(categoryIds);
            return ResponseEntity.ok().body(spots);
        } catch (Exception e){
            log.info("카테고리별 스팟 리스트 조회에 실패하였습니다.", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("카테고리별 스팟 리스트 조회에 실패하였습니다.");
        }
    }
}
