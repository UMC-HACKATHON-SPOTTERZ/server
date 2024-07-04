package com.umc.hackaton.snapspot.category.repository;

import com.umc.hackaton.snapspot.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
