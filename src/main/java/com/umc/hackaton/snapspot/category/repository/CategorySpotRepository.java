package com.umc.hackaton.snapspot.category.repository;

import com.umc.hackaton.snapspot.category.entity.Category;
import com.umc.hackaton.snapspot.category.entity.CategorySpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorySpotRepository extends JpaRepository<CategorySpot, Long> {
    List<CategorySpot> findAllByCategory(Category category);
}
