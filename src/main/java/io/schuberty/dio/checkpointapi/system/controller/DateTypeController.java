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
import io.schuberty.dio.checkpointapi.model.checkpoint.DateType;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.service.DateTypeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/date-type")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DateTypeController {

    private DateTypeService dateTypeService;

    @ApiOperation(value = "Create a dateType and returns its ID")
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createDateType(@RequestBody DateType dateType) {
        return this.dateTypeService.create(dateType);
    }

    @ApiOperation(value = "Return all dateTypes")
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<DateType> listAll() {
        return this.dateTypeService.listAll();
    }

    @ApiOperation(value = "Return a dateType by giving an ID")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DateType findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.dateTypeService.findById(id);
    }

    @ApiOperation(value = "Update a dateType by giving an ID")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody DateType dateType) throws EntityNotFoundException {
        return this.dateTypeService.updateById(id, dateType);
    }

    @ApiOperation(value = "Delete a dateType by giving an ID")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.dateTypeService.delete(id);
    }
}