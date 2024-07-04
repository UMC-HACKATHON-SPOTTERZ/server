package com.umc.hackaton.snapspot.mypage.dto;

import lombok.Builder;
import lombok.Getter;

public class MypageDto {
    @Builder
    @Getter
    public static class MySptDto{
        Long spotId;
        String imageUrl;
        Long likeNum;
    }

    @Builder
    @Getter
    public static class MyProfile{
        String nickName;
        String imageUrl;
    }
}
