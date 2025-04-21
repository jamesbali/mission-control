package com.bali.missioncontrol.controller;

import com.bali.missioncontrol.dto.requestdto.SatelliteRequestDto;
import com.bali.missioncontrol.dto.responsedto.SatelliteResponseDto;
import com.bali.missioncontrol.service.SatelliteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class SatelliteController {

    private final SatelliteService satelliteService;

    @PostMapping
    public ResponseEntity<SatelliteResponseDto> createSatellite(
            @Valid @RequestBody SatelliteRequestDto dto
    ) {
        SatelliteResponseDto response = satelliteService.createSatellite(dto);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SatelliteResponseDto> updateSatellite(
            @PathVariable Long id,
            @Valid @RequestBody SatelliteRequestDto dto
    ) {
        return ResponseEntity.ok(satelliteService.updateSatellite(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<SatelliteResponseDto>> getAllSatellites() {
        return ResponseEntity.ok(satelliteService.getAllSatellites());
    }


}
