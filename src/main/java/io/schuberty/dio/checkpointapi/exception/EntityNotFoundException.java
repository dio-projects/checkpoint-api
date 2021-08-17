package io.schuberty.dio.checkpointapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String entityName, Long id) {
        super(entityName + " not found with ID " + id);
    }
}