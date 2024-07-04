package com.umc.hackaton.snapspot.savespot.service;

import com.umc.hackaton.snapspot.savespot.dto.SpotSaveReqeustDto;
import com.umc.hackaton.snapspot.savespot.dto.SpotSaveResponseDto;
import com.umc.hackaton.snapspot.savespot.entity.SpotSave;
import com.umc.hackaton.snapspot.savespot.entity.UserFolder;
import com.umc.hackaton.snapspot.savespot.repository.SpotSaveRepository;
import com.umc.hackaton.snapspot.savespot.repository.UserFolderRepository;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.spot.repository.SpotRepository;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SpotSaveService {

    private final SpotSaveRepository spotSaveRepository;
    private final UserFolderRepository userFolderRepository;
    private final SpotRepository spotRepository;
    private final UserRepository userRepository;

    @Transactional
    public SpotSaveResponseDto save(SpotSaveReqeustDto dto) {
        UserFolder userFolder = userFolderRepository.findById(dto.getFolderId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid folder ID"));
        Spot spot = spotRepository.findById(dto.getSpotId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid spot ID"));
        SpotSave spotSave = dto.toEntity(userFolder, spot);
        SpotSave savedSpotSave = spotSaveRepository.save(spotSave);
        return SpotSaveResponseDto.fromEntity(userFolder.getId(), List.of(spot));
    }

    @Transactional
    public void delete(Long spotSaveId) {
        spotSaveRepository.deleteById(spotSaveId);
    }

    @Transactional
    public SpotSaveResponseDto getSpotsByFolderId(Long folderId) {
        List<SpotSave> spotSaves = spotSaveRepository.findAllByUserFolder_Id(folderId);
        List<Spot> spots = spotSaves.stream()
                .map(SpotSave::getSpot)
                .collect(Collectors.toList());
        return SpotSaveResponseDto.fromEntity(folderId, spots);
    }
}
