package com.bali.missioncontrol.dto.requestdto;

import com.bali.missioncontrol.model.enums.OrbitType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record SatelliteRequestDto(
        @NotBlank
        String name,

        @Past
        LocalDate launchDate,

        OrbitType orbitType,

        boolean decommissioned

        
) {
}
