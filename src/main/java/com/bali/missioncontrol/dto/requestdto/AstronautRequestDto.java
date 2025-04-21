package com.bali.missioncontrol.dto.requestdto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.*;

import java.util.Set;

public record AstronautRequestDto(

        @NotBlank
        @Size(min = 2, max = 20)
        String firstName,

        @NotBlank
        @Size(min = 2, max = 20)
        String lastName,

        @Min(0)
        @Max(50)
        int experienceYears,

        @NotEmpty
        Set<Long> satelliteIds // IDs of satellites assigned
) {

}
