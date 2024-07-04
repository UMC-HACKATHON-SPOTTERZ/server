package com.umc.hackaton.snapspot.spot.dto;

import com.umc.hackaton.snapspot.spot.entity.Spot;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SpotRequestDto {
    private Long userId;
    private Double latitude;
    private Double longitude;
    private String title;
    private String description;
    private List<Long> categoryNums;

}
