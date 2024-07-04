package com.umc.hackaton.snapspot.spot.service;

import com.umc.hackaton.snapspot.spot.dto.SpotDto;
import com.umc.hackaton.snapspot.spot.dto.SpotRequestDto;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.spot.repository.SpotRepository;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpotService {
    private final SpotRepository spotRepository;
    private final UserRepository userRepository;

    @Transactional
    public void upload(SpotRequestDto dto) {

        User user = userRepository.findUserById(dto.getUserId());

        SpotDto spotDto = new SpotDto();
        spotDto.setUser(user);
        spotDto.setLongitude(dto.getLongitude());
        spotDto.setLatitude(dto.getLatitude());
        spotDto.setTitle(dto.getTitle());
        spotDto.setDescription(dto.getDescription());
        spotDto.setImgUrl(dto.getImgUrl());

        spotRepository.save(spotDto.toEntity());

    }
}
