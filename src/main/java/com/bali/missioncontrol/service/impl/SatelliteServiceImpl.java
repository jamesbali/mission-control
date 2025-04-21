package com.bali.missioncontrol.service.impl;

import com.bali.missioncontrol.dto.requestdto.SatelliteRequestDto;
import com.bali.missioncontrol.dto.responsedto.SatelliteResponseDto;
import com.bali.missioncontrol.exception.SatelliteNotFoundException;
import com.bali.missioncontrol.mapper.SatelliteMapper;
import com.bali.missioncontrol.model.Satellite;
import com.bali.missioncontrol.repository.SatelliteRepository;
import com.bali.missioncontrol.service.SatelliteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {

    private final SatelliteRepository satelliteRepository;
    private final SatelliteMapper satelliteMapper;

    @Override
    @Transactional
    public SatelliteResponseDto createSatellite(SatelliteRequestDto dto) {
        Satellite satellite = satelliteMapper.toEntity(dto);
        return satelliteMapper.toDto(satelliteRepository.save(satellite));
    }

    @Override
    @Transactional
    public SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto dto) {
        Satellite satellite = satelliteRepository.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException(id));

        if (satellite.isDecommissioned()) {
            throw new IllegalStateException("Cannot update a decommissioned satellite.");
        }

        satellite.setName(dto.name());
        satellite.setLaunchDate(dto.launchDate());
        satellite.setOrbitType(dto.orbitType());
        satellite.setDecommissioned(dto.decommissioned());

        return satelliteMapper.toDto(satelliteRepository.save(satellite));
    }

    @Override
    public List<SatelliteResponseDto> getAllSatellites() {
        return satelliteRepository.findAll().stream()
                .map(satelliteMapper::toDto)
                .toList();
    }


}
