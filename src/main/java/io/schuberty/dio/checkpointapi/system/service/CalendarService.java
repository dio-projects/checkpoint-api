package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.Calendar;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.repository.CalendarRepository;
import io.schuberty.dio.checkpointapi.system.utils.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CalendarService {
    
    private CalendarRepository calendarRepository;

    public MessageResponseDTO create(Calendar calendar) {
        Calendar createdCalendar = this.calendarRepository.save(calendar);
        return MessageResponse.create("Created Calendar with ID " + createdCalendar.getId());
    }

    public List<Calendar> listAll() {
        return this.calendarRepository.findAll();
    }
    
    public Calendar findById(Long id) throws EntityNotFoundException {
        Calendar calendar = verifyIfExists(id);
        return calendar;
    }

    public MessageResponseDTO updateById(Long id, Calendar calendar) throws EntityNotFoundException {
        verifyIfExists(id);
        Calendar updatedCalendar = this.calendarRepository.save(calendar);
        return MessageResponse.create("Updated calendar with ID " + updatedCalendar.getId());
    } 

    public MessageResponseDTO delete(Long id) throws EntityNotFoundException {
        verifyIfExists(id);
        this.calendarRepository.deleteById(id);
        return MessageResponse.create("Deleted calendar with ID " + id);
    }

    private Calendar verifyIfExists(Long id) throws EntityNotFoundException {
        return this.calendarRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Calendar", id));
    }
}