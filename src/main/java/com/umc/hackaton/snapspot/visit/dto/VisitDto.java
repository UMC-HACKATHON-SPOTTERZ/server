package com.umc.hackaton.snapspot.visit.dto;

import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.visit.entity.Visit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitDto {
    private Spot spot;
    private User user;

    public Visit toEntity() {
        return Visit.builder()
                .spot(spot)
                .user(user)
                .build();
    }
}
