package com.bali.missioncontrol.repository;

import com.bali.missioncontrol.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronautRepository extends JpaRepository <Astronaut, Long> {
    

}
