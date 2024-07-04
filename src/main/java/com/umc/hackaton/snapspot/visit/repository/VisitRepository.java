package com.umc.hackaton.snapspot.visit.repository;

import com.umc.hackaton.snapspot.visit.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    Optional<Visit> findBySpotId(Long spotId);
}
