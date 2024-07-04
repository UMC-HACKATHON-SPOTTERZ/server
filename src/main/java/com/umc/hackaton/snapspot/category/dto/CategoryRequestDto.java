package com.umc.hackaton.snapspot.category.dto;

import com.umc.hackaton.snapspot.category.entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CategoryRequestDto {
    @NotNull private String categoryName;

    @Builder
    public Category toEntity() {
        return Category.builder()
                .categoryName(categoryName)
                .build();
    }
}
