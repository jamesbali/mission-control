package com.bali.missioncontrol.service;

import com.bali.missioncontrol.dto.requestdto.SatelliteRequestDto;
import com.bali.missioncontrol.dto.responsedto.SatelliteResponseDto;

import java.util.List;

public interface SatelliteService {

    SatelliteResponseDto createSatellite(SatelliteRequestDto dto);
    SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto dto);
    List<SatelliteResponseDto> getAllSatellites();


}
