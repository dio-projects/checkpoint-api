package io.schuberty.dio.checkpointapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JourneyNotFoundException extends Exception {

    public JourneyNotFoundException(Long id) {
        super("Journey not found with ID " + id);
    }
}