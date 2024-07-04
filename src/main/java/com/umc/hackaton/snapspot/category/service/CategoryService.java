package com.umc.hackaton.snapspot.category.service;

import com.umc.hackaton.snapspot.category.dto.CategoryRequestDto;
import com.umc.hackaton.snapspot.category.entity.Category;
import com.umc.hackaton.snapspot.category.entity.CategorySpot;
import com.umc.hackaton.snapspot.category.repository.CategoryRepository;
import com.umc.hackaton.snapspot.category.repository.CategorySpotRepository;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategorySpotRepository categorySpotRepository;


    public void save(CategoryRequestDto category) {
        categoryRepository.save(category.toEntity());
    }

    public List<Category> showAll() {
        List<Object[]> objects = categoryRepository.findAllCategories();
        return objects.stream()
                .map(object -> new Category((Long) object[0], (String) object[1]))
                .collect(Collectors.toList());
    }

    public List<Spot> showSpotsByCategoryIds(List<Long> categoryIds) {
        Set<Spot> spots = new HashSet<>();
        for (Long categoryId : categoryIds) {
            Category category = categoryRepository.findById(categoryId).orElse(null);
            if (category != null) {
                List<CategorySpot> categorySpots = categorySpotRepository.findAllByCategory(category);
                List<Spot> categorySpotsMapped = categorySpots.stream()
                        .map(CategorySpot::getSpot)
                        .collect(Collectors.toList());
                spots.addAll(categorySpotsMapped);
            }
        }
        return new ArrayList<>(spots);
    }
}
