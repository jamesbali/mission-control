package com.bali.missioncontrol.repository;

import com.bali.missioncontrol.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepository extends JpaRepository <Satellite, Long> {

}
