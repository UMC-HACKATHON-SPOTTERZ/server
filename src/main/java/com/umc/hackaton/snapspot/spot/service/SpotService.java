package com.umc.hackaton.snapspot.spot.service;

import com.umc.hackaton.snapspot.S3.S3Service;
import com.umc.hackaton.snapspot.category.entity.Category;
import com.umc.hackaton.snapspot.category.entity.CategorySpot;
import com.umc.hackaton.snapspot.category.repository.CategoryRepository;
import com.umc.hackaton.snapspot.category.repository.CategorySpotRepository;
import com.umc.hackaton.snapspot.spot.converter.SpotConverter;
import com.umc.hackaton.snapspot.spot.dto.SpotDto;
import com.umc.hackaton.snapspot.spot.dto.SpotRequestDto;
import com.umc.hackaton.snapspot.spot.dto.SpotResponseDto;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import com.umc.hackaton.snapspot.spot.repository.SpotRepository;
import com.umc.hackaton.snapspot.user.entity.User;
import com.umc.hackaton.snapspot.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpotService {
    private static final Logger log = LoggerFactory.getLogger(SpotService.class);
    private final SpotRepository spotRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final CategorySpotRepository categorySpotRepository;
    private final S3Service s3Service;

    @Transactional
    public Spot upload(SpotRequestDto dto, MultipartFile file) {

        String imgUrl = s3Service.saveFile(file);
        log.info("imgUrl: " + imgUrl);

        User user = userRepository.findUserById(dto.getUserId());

        SpotDto spotDto = new SpotDto();
        spotDto.setUser(user);
        spotDto.setLongitude(dto.getLongitude());
        spotDto.setLatitude(dto.getLatitude());
        spotDto.setTitle(dto.getTitle());
        spotDto.setDescription(dto.getDescription());
        spotDto.setImgUrl(imgUrl);

        Spot savedSpot = spotRepository.save(spotDto.toEntity());

        List<CategorySpot> categorySpots = new ArrayList<>();
        for (Long categoryId : dto.getCategoryNums()) {
            Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
            categoryOptional.ifPresent(category -> {
                CategorySpot categorySpot = CategorySpot.builder()
                        .category(category)
                        .spot(savedSpot)
                        .build();
                categorySpots.add(categorySpot);
            });
        }

        // CategorySpot 저장
        categorySpotRepository.saveAll(categorySpots);
        return savedSpot;
    }



    @Transactional
    public Spot getSpotById(Long spotId) {
        // spotId를 사용하여 Repository를 통해 Spot을 가져옴
        return spotRepository.findById(spotId)
                .orElseThrow(() -> new RuntimeException("Spot not found with id: " + spotId));
    }

    public Spot getSpot(Long spotId) {
        return spotRepository.findById(spotId).orElse(null);
    }

    public void deleteSpot(Long spotId) {
        spotRepository.deleteById(spotId);
    }

    public Spot updateSpot(Long spotId, SpotRequestDto dto) {
        Spot spot = spotRepository.findById(spotId).orElse(null);
        return spot.update(dto);
    }

    public List<SpotResponseDto> readNearSpotList(double latitude, double longitude) {
        List<Spot> spotList = spotRepository.findSpotsWithinDistance(latitude, longitude, 0.5);
        return SpotConverter.toDtoList(spotList);
    }
}
