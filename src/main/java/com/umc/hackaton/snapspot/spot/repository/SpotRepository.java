package com.umc.hackaton.snapspot.spot.repository;

import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Long> {
    List<Spot> findAllByUser(User user);
}
