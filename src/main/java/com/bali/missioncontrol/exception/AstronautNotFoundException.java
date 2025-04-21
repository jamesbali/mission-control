package com.bali.missioncontrol.exception;

public class AstronautNotFoundException extends RuntimeException{

    public AstronautNotFoundException(Long id) {
        super("Astronaut with ID " + id + " not found.");
    }

}
