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
import io.schuberty.dio.checkpointapi.model.checkpoint.AnnualLeave;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.service.AnnualLeaveService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/annual-leave")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnnualLeaveController {

    private AnnualLeaveService annualLeaveService;

    @ApiOperation(value = "Create a annual leave and returns its ID")
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createAnnualLeave(@RequestBody AnnualLeave annualLeave) {
        return this.annualLeaveService.create(annualLeave);
    }

    @ApiOperation(value = "Return all annual leaves")
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<AnnualLeave> listAll() {
        return this.annualLeaveService.listAll();
    }

    @ApiOperation(value = "Return a annual leave by giving an ID")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnnualLeave findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.annualLeaveService.findById(id);
    }

    @ApiOperation(value = "Update a annual leave by giving an ID")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody AnnualLeave annualLeave) throws EntityNotFoundException {
        return this.annualLeaveService.updateById(id, annualLeave);
    }

    @ApiOperation(value = "Delete a annual leave by giving an ID")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.annualLeaveService.delete(id);
    }
}