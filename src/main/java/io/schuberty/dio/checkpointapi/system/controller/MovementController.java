package io.schuberty.dio.checkpointapi.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.Movement;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.service.MovementService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/movement")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovementController {

    private MovementService movementService;

    @ApiOperation(value = "Create a movement and returns its ID")
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createMovement(@RequestBody Movement movement) {
        return this.movementService.create(movement);
    }

    @ApiOperation(value = "Return all movements")
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Movement> listAll() {
        return this.movementService.listAll();
    }

    @ApiOperation(value = "Return a movement by giving an ID")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movement findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.movementService.findById(id);
    }

    @ApiOperation(value = "Update a movement by giving an ID")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody Movement movement) throws EntityNotFoundException {
        return this.movementService.updateById(id, movement);
    }

    @ApiOperation(value = "Delete a movement by giving an ID")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.movementService.delete(id);
    }
}