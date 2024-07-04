package com.umc.hackaton.snapspot.mypage.converter;

import com.umc.hackaton.snapspot.mypage.dto.MypageDto;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.user.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class MypageConverter {

    public static List<MypageDto.MySptDto> toDtoList(List<Spot> spotList){
        return spotList.stream()
                .map(MypageConverter::toMySptDto)
                .collect(Collectors.toList());
    }

    public static MypageDto.MySptDto toMySptDto(Spot spot){
        return MypageDto.MySptDto.builder()
                .imageUrl(spot.getImgUrl())
                .likeNum(spot.getLikeNum())
                .spotId(spot.getId())
                .build();
    }
    public static MypageDto.MyProfile toMyProfileDto(User user){
        return MypageDto.MyProfile.builder()
                .imageUrl(user.getProfileImg())
                .nickName(user.getNickname())
                .build();
    }
}
