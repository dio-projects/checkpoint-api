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
import io.schuberty.dio.checkpointapi.model.checkpoint.Calendar;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.service.CalendarService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/calendar")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CalendarController {

    private CalendarService calendarService;

    @ApiOperation(value = "Create a calendar and returns its ID")
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCalendar(@RequestBody Calendar calendar) {
        return this.calendarService.create(calendar);
    }

    @ApiOperation(value = "Return all calendars")
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Calendar> listAll() {
        return this.calendarService.listAll();
    }

    @ApiOperation(value = "Return a calendar by giving an ID")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Calendar findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.calendarService.findById(id);
    }

    @ApiOperation(value = "Update a calendar by giving an ID")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody Calendar calendar) throws EntityNotFoundException {
        return this.calendarService.updateById(id, calendar);
    }

    @ApiOperation(value = "Delete a calendar by giving an ID")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.calendarService.delete(id);
    }
}