package com.umc.hackaton.snapspot.spot.repository;

import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpotRepository extends JpaRepository<Spot, Long> {
    List<Spot> findAllByUser(User user);

    @Query(value = "SELECT * FROM Spot s " +
            "WHERE (6371 * 2 * ASIN(SQRT(POWER(SIN((RADIANS(:latitude) - RADIANS(s.latitude)) / 2), 2) + " +
            "COS(RADIANS(:latitude)) * COS(RADIANS(s.latitude)) * POWER(SIN((RADIANS(:longitude) - RADIANS(s.longitude)) / 2), 2)))) < :distance", nativeQuery = true)
    List<Spot> findSpotsWithinDistance(@Param("latitude") double latitude,
                                       @Param("longitude") double longitude,
                                       @Param("distance") double distance);
}
