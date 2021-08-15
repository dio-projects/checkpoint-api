package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.JourneyNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.WorkJourney;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.repository.WorkJourneyRepository;
import io.schuberty.dio.checkpointapi.system.utils.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WorkJourneyService {

    private WorkJourneyRepository journeyRepository;

    public MessageResponseDTO create(WorkJourney journey) {
        WorkJourney createdJourney = this.journeyRepository.save(journey);
        return MessageResponse.create("Created journey with ID " + createdJourney.getId());
    }
    
    public List<WorkJourney> listAll() {
        return this.journeyRepository.findAll();
    }

    public WorkJourney findById(Long id) throws JourneyNotFoundException {
        WorkJourney journey = verifyIfExists(id);
        return journey;
    }

    public MessageResponseDTO updateById(Long id, WorkJourney journey) throws JourneyNotFoundException {
        verifyIfExists(id);
        WorkJourney updatedJourney = this.journeyRepository.save(journey);
        return MessageResponse.create("Updated journey with ID " + updatedJourney.getId());
    } 

    public MessageResponseDTO delete(Long id) throws JourneyNotFoundException {
        verifyIfExists(id);
        this.journeyRepository.deleteById(id);
        return MessageResponse.create("Deleted journey with ID " + id);
    }

    private WorkJourney verifyIfExists(Long id) throws JourneyNotFoundException {
        return this.journeyRepository.findById(id)
            .orElseThrow(() -> new JourneyNotFoundException(id));
    }
}