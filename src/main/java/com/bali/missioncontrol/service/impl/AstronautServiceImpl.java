package com.bali.missioncontrol.service.impl;

import com.bali.missioncontrol.dto.requestdto.AstronautRequestDto;
import com.bali.missioncontrol.dto.responsedto.AstronautResponseDto;
import com.bali.missioncontrol.exception.SatelliteNotFoundException;
import com.bali.missioncontrol.mapper.AstronautMapper;
import com.bali.missioncontrol.model.Astronaut;
import com.bali.missioncontrol.model.Satellite;
import com.bali.missioncontrol.repository.AstronautRepository;
import com.bali.missioncontrol.repository.SatelliteRepository;
import com.bali.missioncontrol.service.AstronautService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {

    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;
    private final AstronautMapper astronautMapper;

    @Override
    @Transactional
    public AstronautResponseDto createAstronaut(AstronautRequestDto dto) {
        Astronaut astronaut = astronautMapper.toEntity(dto);

        Set<Satellite> satellites = dto.satelliteIds().stream()
                .map(id -> satelliteRepository.findById(id)
                        .orElseThrow(() -> new SatelliteNotFoundException(id)))
                .collect(Collectors.toSet());

        astronaut.setSatellites(satellites);
        return astronautMapper.toDto(astronautRepository.save(astronaut));
    }

    @Override
    public List<AstronautResponseDto> getAllAstronauts() {
        return astronautRepository.findAll().stream()
                .map(astronautMapper::toDto)
                .collect(Collectors.toList());
    }

}
