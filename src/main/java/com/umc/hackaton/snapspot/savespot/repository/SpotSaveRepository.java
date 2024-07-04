package com.umc.hackaton.snapspot.savespot.repository;

import com.umc.hackaton.snapspot.savespot.dto.SpotSaveResponseDto;
import com.umc.hackaton.snapspot.savespot.entity.SpotSave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotSaveRepository extends JpaRepository<SpotSave, Long> {
    List<SpotSave> findAllByUserFolder_Id(Long userFolderId);
}
