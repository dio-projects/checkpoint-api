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

import io.schuberty.dio.checkpointapi.exception.JourneyNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.WorkJourney;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.service.WorkJourneyService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/journey")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WorkJourneyController {

    private WorkJourneyService journeyService;

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createJourney(@RequestBody WorkJourney journey) {
        return this.journeyService.create(journey);
    }

    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<WorkJourney> listAll() {
        return this.journeyService.listAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkJourney findById(@PathVariable("id") Long id) throws JourneyNotFoundException {
        return this.journeyService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody WorkJourney journey) throws JourneyNotFoundException {
        return this.journeyService.updateById(id, journey);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteById(@PathVariable("id") Long id) throws JourneyNotFoundException {
        return this.journeyService.delete(id);
    }
}