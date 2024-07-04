package com.umc.hackaton.snapspot.visit.dto;

import com.umc.hackaton.snapspot.visit.entity.Visit;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VisitResponseDto {
    private Long id;
    private Long spotId;
    private Long userId;

    public static VisitResponseDto fromEntity(Visit visit) {
        return VisitResponseDto.builder()
                .id(visit.getId())
                .spotId(visit.getSpot().getId())
                .userId(visit.getUser().getId())
                .build();
    }
}
