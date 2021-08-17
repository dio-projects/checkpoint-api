package io.schuberty.dio.checkpointapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccessNotFoundException extends Exception {

    public AccessNotFoundException(Long id) {
        super("Access Level not found with ID " + id);
    }
}