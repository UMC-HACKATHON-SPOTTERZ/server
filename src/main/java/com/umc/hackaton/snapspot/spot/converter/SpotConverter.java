package com.umc.hackaton.snapspot.spot.converter;

import com.umc.hackaton.snapspot.spot.dto.SpotResponseDto;
import com.umc.hackaton.snapspot.spot.entity.Spot;

import java.util.List;
import java.util.stream.Collectors;

public class SpotConverter {
    public static List<SpotResponseDto>toDtoList(List<Spot> spotList){
        return spotList.stream()
                .map(SpotConverter::toDto)
                .collect(Collectors.toList());
    }

    public static SpotResponseDto toDto(Spot spot){
        return SpotResponseDto.builder()
                .spotId(spot.getId())
                .imgUrl(spot.getImgUrl())
                .likeNum(spot.getLikeNum())
                .build();
    }
}
