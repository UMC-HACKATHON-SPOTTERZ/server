package com.umc.hackaton.snapspot.spot.dto;

import lombok.Builder;

@Builder
public class SpotResponseDto {
    Long spotId;
    String imgUrl;

    Long likeNum;
}
