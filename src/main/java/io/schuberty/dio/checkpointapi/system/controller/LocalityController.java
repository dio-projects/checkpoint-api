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
import io.schuberty.dio.checkpointapi.model.checkpoint.Locality;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.service.LocalityService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/locality")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LocalityController {

    private LocalityService localityService;

    @ApiOperation(value = "Create a locality and returns its ID")
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createLocality(@RequestBody Locality locality) {
        return this.localityService.create(locality);
    }

    @ApiOperation(value = "Return all localitys")
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Locality> listAll() {
        return this.localityService.listAll();
    }

    @ApiOperation(value = "Return a locality by giving an ID")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Locality findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.localityService.findById(id);
    }

    @ApiOperation(value = "Update a locality by giving an ID")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody Locality locality) throws EntityNotFoundException {
        return this.localityService.updateById(id, locality);
    }

    @ApiOperation(value = "Delete a locality by giving an ID")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.localityService.delete(id);
    }
}