package com.umc.hackaton.snapspot.savespot.dto;

import com.umc.hackaton.snapspot.savespot.entity.SpotSave;
import com.umc.hackaton.snapspot.savespot.entity.UserFolder;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SpotSaveReqeustDto {
    @NotNull private Long folderId;
    @NotNull private Long spotId;

    @Builder
    public SpotSave toEntity(UserFolder userFolder, Spot spot){
        return SpotSave.builder()
                .userFolder(userFolder)
                .spot(spot)
                .build();
    }
}
