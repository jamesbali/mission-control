package com.bali.missioncontrol.mapper;


import com.bali.missioncontrol.dto.requestdto.SatelliteRequestDto;
import com.bali.missioncontrol.dto.responsedto.SatelliteResponseDto;
import com.bali.missioncontrol.model.Satellite;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SatelliteMapper {

    SatelliteMapper INSTANCE = Mappers.getMapper(SatelliteMapper.class);

    Satellite toEntity(SatelliteRequestDto dto);

    SatelliteResponseDto toDto(Satellite satellite);

    
    
    
}
