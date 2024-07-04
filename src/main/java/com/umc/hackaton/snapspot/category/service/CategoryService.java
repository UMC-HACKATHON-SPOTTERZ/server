package com.umc.hackaton.snapspot.category.service;

import com.umc.hackaton.snapspot.category.dto.CategoryRequestDto;
import com.umc.hackaton.snapspot.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public void save(CategoryRequestDto category) {
        categoryRepository.save(category.toEntity());
    }
}
