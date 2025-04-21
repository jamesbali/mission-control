package com.bali.missioncontrol.mapper;


import com.bali.missioncontrol.dto.requestdto.AstronautRequestDto;
import com.bali.missioncontrol.dto.responsedto.AstronautResponseDto;
import com.bali.missioncontrol.model.Astronaut;
import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {SatelliteMapper.class})
public interface AstronautMapper {

    AstronautMapper INSTANCE = Mappers.getMapper(AstronautMapper.class);

    @Mapping(target = "id", ignore = true) // Since ID is auto generated
    @Mapping(target = "satellites", ignore = true) // We'll set manually in service
    Astronaut toEntity(AstronautRequestDto dto);

    AstronautResponseDto toDto(Astronaut astronaut);
    
    
}
