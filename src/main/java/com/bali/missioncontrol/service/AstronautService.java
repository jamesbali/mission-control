package com.bali.missioncontrol.service;

import com.bali.missioncontrol.dto.requestdto.AstronautRequestDto;
import com.bali.missioncontrol.dto.responsedto.AstronautResponseDto;

import java.util.List;

public interface AstronautService {
    AstronautResponseDto createAstronaut(AstronautRequestDto dto);
    List<AstronautResponseDto> getAllAstronauts();


}
