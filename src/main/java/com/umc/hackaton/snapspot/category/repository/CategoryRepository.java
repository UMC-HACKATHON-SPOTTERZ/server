package com.umc.hackaton.snapspot.category.repository;

import com.umc.hackaton.snapspot.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c.id, c.categoryName FROM Category c")
    List<Object[]> findAllCategories();
}
