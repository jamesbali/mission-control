package com.bali.missioncontrol.dto.responsedto;


import java.util.Set;

public record AstronautResponseDto(

        Long id,
        String firstName,
        String lastName,
        int experienceYears,
        Set<SatelliteResponseDto> satellites // Nested response
) {
}
