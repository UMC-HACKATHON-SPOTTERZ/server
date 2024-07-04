package com.umc.hackaton.snapspot.visit.service;

import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.spot.repository.SpotRepository;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import com.umc.hackaton.snapspot.visit.dto.VisitDto;
import com.umc.hackaton.snapspot.visit.dto.VisitRequestDto;
import com.umc.hackaton.snapspot.visit.dto.VisitResponseDto;
import com.umc.hackaton.snapspot.visit.entity.Visit;
import com.umc.hackaton.snapspot.visit.repository.VisitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final UserRepository userRepository;
    private final SpotRepository spotRepository;

    @Transactional
    public void saveVisit(VisitRequestDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Spot spot = spotRepository.findById(dto.getSpotId())
                .orElseThrow(() -> new IllegalArgumentException("스팟을 찾을 수 없습니다."));

        VisitDto visitDto = new VisitDto();
        visitDto.setUser(user);
        visitDto.setSpot(spot);

        visitRepository.save(visitDto.toEntity());

    }

    @Transactional
    public VisitResponseDto getVisit(Long spotId) {
        Optional<Visit> visit = visitRepository.findBySpotId(spotId);

       if (visit.isEmpty()) {
            throw new IllegalArgumentException("해당 스팟에 대한 방문 정보가 없습니다.");
        }

        return VisitResponseDto.fromEntity(visit.get());
    }
}
