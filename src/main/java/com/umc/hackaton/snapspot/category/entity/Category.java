package com.umc.hackaton.snapspot.category.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.umc.hackaton.snapspot.config.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @ToString.Exclude
    @JsonManagedReference
    @OrderBy("id")
    @OneToMany(mappedBy = "category")
    private final Set<CategorySpot> categorySpots = new LinkedHashSet<>();
}
