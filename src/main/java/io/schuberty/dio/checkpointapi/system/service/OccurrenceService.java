package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.Occurrence;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.repository.OccurrenceRepository;
import io.schuberty.dio.checkpointapi.system.utils.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OccurrenceService {
    
    private OccurrenceRepository occurrenceRepository;

    public MessageResponseDTO create(Occurrence occurrence) {
        Occurrence createdOccurrence = this.occurrenceRepository.save(occurrence);
        return MessageResponse.create("Created occurrence with ID " + createdOccurrence.getId());
    }

    public List<Occurrence> listAll() {
        return this.occurrenceRepository.findAll();
    }
    
    public Occurrence findById(Long id) throws EntityNotFoundException {
        Occurrence occurrence = verifyIfExists(id);
        return occurrence;
    }

    public MessageResponseDTO updateById(Long id, Occurrence occurrence) throws EntityNotFoundException {
        verifyIfExists(id);
        Occurrence updatedOccurrence = this.occurrenceRepository.save(occurrence);
        return MessageResponse.create("Updated occurrence with ID " + updatedOccurrence.getId());
    } 

    public MessageResponseDTO delete(Long id) throws EntityNotFoundException {
        verifyIfExists(id);
        this.occurrenceRepository.deleteById(id);
        return MessageResponse.create("Deleted occurrence with ID " + id);
    }

    private Occurrence verifyIfExists(Long id) throws EntityNotFoundException {
        return this.occurrenceRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Occurrence", id));
    }
}