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
import io.schuberty.dio.checkpointapi.model.checkpoint.Occurrence;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.service.OccurrenceService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/occurrence")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OccurrenceController {

    private OccurrenceService occurrenceService;

    @ApiOperation(value = "Create a occurrence and returns its ID")
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createOccurrence(@RequestBody Occurrence occurrence) {
        return this.occurrenceService.create(occurrence);
    }

    @ApiOperation(value = "Return all occurrences")
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Occurrence> listAll() {
        return this.occurrenceService.listAll();
    }

    @ApiOperation(value = "Return a occurrence by giving an ID")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Occurrence findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.occurrenceService.findById(id);
    }

    @ApiOperation(value = "Update a occurrence by giving an ID")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody Occurrence occurrence) throws EntityNotFoundException {
        return this.occurrenceService.updateById(id, occurrence);
    }

    @ApiOperation(value = "Delete a occurrence by giving an ID")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.occurrenceService.delete(id);
    }
}