package com.bali.missioncontrol.exception;

public class SatelliteNotFoundException extends RuntimeException {

    public SatelliteNotFoundException(Long id) {
        super("Satellite with ID " + id + " not found.");
    }

}
