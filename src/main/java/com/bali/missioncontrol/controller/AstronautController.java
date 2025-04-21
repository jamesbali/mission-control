package com.bali.missioncontrol.controller;

import com.bali.missioncontrol.dto.requestdto.AstronautRequestDto;
import com.bali.missioncontrol.dto.responsedto.AstronautResponseDto;
import com.bali.missioncontrol.service.AstronautService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class AstronautController {

    private final AstronautService astronautService;

    @PostMapping
    public ResponseEntity<AstronautResponseDto> createAstronaut(
            @Valid @RequestBody AstronautRequestDto dto
    ) {
        AstronautResponseDto response = astronautService.createAstronaut(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AstronautResponseDto>> getAllAstronauts() {
        return ResponseEntity.ok(astronautService.getAllAstronauts());
    }
}
