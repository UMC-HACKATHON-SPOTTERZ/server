package com.umc.hackaton.snapspot.like.dto;

import lombok.Builder;
import lombok.Getter;

public class LikeDto {
    @Builder
    @Getter
    public static class RequestDto{
        Long userId;
        Long spotId;

    }

    @Builder
    @Getter
    public static class ResponseDto{
        String message;

    }
}
