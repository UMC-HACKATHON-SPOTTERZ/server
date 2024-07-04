package com.umc.hackaton.snapspot.spot.repository;

import com.umc.hackaton.snapspot.spot.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpotRepository extends JpaRepository<Spot, Long> {
}
