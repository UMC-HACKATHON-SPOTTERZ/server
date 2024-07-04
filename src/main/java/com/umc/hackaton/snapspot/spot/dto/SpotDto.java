package com.umc.hackaton.snapspot.spot.dto;

import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotDto {

    private User user;
    private Double latitude;
    private Double longitude;
    private String title;
    private String description;
    private String imgUrl;

    @Builder
    public Spot toEntity() {
        return Spot.builder()
                .user(user)
                .latitude(latitude)
                .longitude(longitude)
                .title(title)
                .description(description)
                .imgUrl(imgUrl)
                .build();
    }
}
