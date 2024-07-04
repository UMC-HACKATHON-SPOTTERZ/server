package com.umc.hackaton.snapspot.like.service;

import com.umc.hackaton.snapspot.like.converter.LikeConverter;
import com.umc.hackaton.snapspot.like.dto.LikeDto;
import com.umc.hackaton.snapspot.like.entity.Like;
import com.umc.hackaton.snapspot.like.repository.LikeRepository;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.spot.repository.SpotRepository;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final SpotRepository spotRepository;
    private final UserRepository userRepository;

    public LikeDto.ResponseDto registerLike(LikeDto.RequestDto likeDto) {
        User user = userRepository.findById(likeDto.getUserId()).orElseThrow(()->new IllegalArgumentException("존재하지 않는 사용자입니다."));

        Spot spot  = spotRepository.findById(likeDto.getSpotId()).orElseThrow(()->new IllegalArgumentException("존재하지 않는 스팟입니다."));
        Like likeEntity = likeRepository.findByUserAndSpot(user, spot);

        if(likeEntity == null){
            Like saveLike = LikeConverter.toEntity(user, spot);
            likeRepository.save(saveLike);
            //like 하나 증가
            spot.increaseLike();
            spotRepository.save(spot);
            return LikeDto.ResponseDto.builder()
                    .message("좋아요 등록 완료").build();
        }
        return LikeDto.ResponseDto.builder()
                .message("좋아요 등록 실패").build();
    }


    public LikeDto.ResponseDto deleteLike(LikeDto.RequestDto likeDto) {
        User user = userRepository.findById(likeDto.getUserId()).orElseThrow(()->new IllegalArgumentException("존재하지 않는 사용자입니다."));

        Spot spot  = spotRepository.findById(likeDto.getSpotId()).orElseThrow(()->new IllegalArgumentException("존재하지 않는 스팟입니다."));

        Like likeEntity = likeRepository.findByUserAndSpot(user, spot);

        if(likeEntity != null){
            likeRepository.delete(likeEntity);
            spot.decreaseLike();
            spotRepository.save(spot);
            return LikeDto.ResponseDto.builder()
                    .message("삭제 완료").build();
        }
        return LikeDto.ResponseDto.builder()
                .message("좋아요 삭제에 실패했습니다.").build();
    }
}
