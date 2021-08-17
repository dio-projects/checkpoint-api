package io.schuberty.dio.checkpointapi.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.AccessLevel;
import io.schuberty.dio.checkpointapi.system.service.AccessLevelService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/access")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccessLevelController {

    private AccessLevelService accessLevelService;

    @ApiOperation(value = "Return all available access levels")
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<AccessLevel> listAll() {
        return this.accessLevelService.listAll();
    }

    @ApiOperation(value = "Return a access level by giving an ID")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccessLevel findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.accessLevelService.findById(id);
    }
}