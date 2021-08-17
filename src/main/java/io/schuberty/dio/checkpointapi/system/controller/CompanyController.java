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

import io.schuberty.dio.checkpointapi.exception.CompanyNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.Company;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/company")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyController {

    private CompanyService companyService;

    @ApiOperation(value = "Create a company and returns its ID")
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createJourney(@RequestBody Company company) {
        return this.companyService.create(company);
    }

    @ApiOperation(value = "Return all companys")
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> listAll() {
        return this.companyService.listAll();
    }

    @ApiOperation(value = "Return a company by giving an ID")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company findById(@PathVariable("id") Long id) throws CompanyNotFoundException {
        return this.companyService.findById(id);
    }

    @ApiOperation(value = "Update a company by giving an ID")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody Company company) throws CompanyNotFoundException {
        return this.companyService.updateById(id, company);
    }

    @ApiOperation(value = "Delete a company by giving an ID")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteById(@PathVariable("id") Long id) throws CompanyNotFoundException {
        return this.companyService.delete(id);
    }
}