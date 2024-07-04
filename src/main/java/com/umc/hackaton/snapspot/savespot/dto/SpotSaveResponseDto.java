package com.umc.hackaton.snapspot.savespot.dto;

import com.umc.hackaton.snapspot.spot.entity.Spot;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class SpotSaveResponseDto {
    private Long folderId;
    private List<Spot> spots;

    public static SpotSaveResponseDto fromEntity(Long folderId, List<Spot> spots) {
        return SpotSaveResponseDto.builder()
                .folderId(folderId)
                .spots(spots)
                .build();
    }
}