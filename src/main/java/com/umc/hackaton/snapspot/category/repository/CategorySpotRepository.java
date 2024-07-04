package com.umc.hackaton.snapspot.category.repository;

import com.umc.hackaton.snapspot.category.entity.Category;
import com.umc.hackaton.snapspot.category.entity.CategorySpot;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategorySpotRepository extends JpaRepository<CategorySpot, Long> {
    List<CategorySpot> findAllByCategory(Category category);

    List<CategorySpot> findAllBySpot(Spot spot);
}
