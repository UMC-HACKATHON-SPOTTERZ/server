package com.umc.hackaton.snapspot.like.converter;

import com.umc.hackaton.snapspot.like.entity.Like;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.user.entity.User;

public class LikeConverter {
    public static Like toEntity(User user, Spot spot){
        return Like.builder()
                .spot(spot)
                .user(user)
                .build();
    }
}
