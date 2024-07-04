package com.umc.hackaton.snapspot.mypage.service;

import com.umc.hackaton.snapspot.mypage.converter.MypageConverter;
import com.umc.hackaton.snapspot.mypage.dto.MypageDto;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.spot.repository.SpotRepository;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MypageService {

    private SpotRepository spotRepository;
    private UserRepository userRepository;

    public List<MypageDto.MySptDto> readAllMySpot(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        List<Spot> spotList = spotRepository.findAllByUser(user);

        return MypageConverter.toDtoList(spotList);
    }

    public MypageDto.MyProfile readMyProfile(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        return MypageConverter.toMyProfileDto(user);
    }


}
