package com.umc.hackaton.snapspot.category.controller;

import com.umc.hackaton.snapspot.category.dto.CategoryRequestDto;
import com.umc.hackaton.snapspot.category.service.CategoryService;
import com.umc.hackaton.snapspot.savespot.dto.UserFolderRequestDto;
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
}
