package com.bali.missioncontrol.dto.responsedto;

import com.bali.missioncontrol.model.enums.OrbitType;

import java.time.LocalDate;

public record SatelliteResponseDto (

        Long id,
        String name,
        LocalDate launchDate,
        OrbitType orbitType,
        boolean decommissioned


) {
}
