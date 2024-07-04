package com.umc.hackaton.snapspot.like.repository;

import com.umc.hackaton.snapspot.like.entity.Like;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    Like findByUserAndSpot(User user, Spot spot);
}
