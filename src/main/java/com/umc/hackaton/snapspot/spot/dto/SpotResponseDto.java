package com.umc.hackaton.snapspot.spot.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SpotResponseDto {
    Long spotId;
    String imgUrl;

    Long likeNum;
}
