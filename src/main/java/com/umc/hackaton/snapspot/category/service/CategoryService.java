package com.umc.hackaton.snapspot.category.service;

import com.umc.hackaton.snapspot.category.dto.CategoryRequestDto;
import com.umc.hackaton.snapspot.category.entity.Category;
import com.umc.hackaton.snapspot.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public void save(CategoryRequestDto category) {
        categoryRepository.save(category.toEntity());
    }

    public List<Category> showAll() {
        List<Object[]> objects = categoryRepository.findAllCategories();
        return objects.stream()
                .map(object -> new Category((Long) object[0], (String) object[1]))
                .collect(Collectors.toList());
    }
}
