package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.Movement;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.repository.MovementRepository;
import io.schuberty.dio.checkpointapi.system.utils.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovementService {
    
    private MovementRepository movementRepository;

    public MessageResponseDTO create(Movement movement) {
        Movement createdMovement = this.movementRepository.save(movement);
        return MessageResponse.create("Created movement with ID " + createdMovement.getId());
    }

    public List<Movement> listAll() {
        return this.movementRepository.findAll();
    }
    
    public Movement findById(Long id) throws EntityNotFoundException {
        Movement movement = verifyIfExists(id);
        return movement;
    }

    public MessageResponseDTO updateById(Long id, Movement movement) throws EntityNotFoundException {
        verifyIfExists(id);
        Movement updatedMovement = this.movementRepository.save(movement);
        return MessageResponse.create("Updated movement with ID " + updatedMovement.getId());
    } 

    public MessageResponseDTO delete(Long id) throws EntityNotFoundException {
        verifyIfExists(id);
        this.movementRepository.deleteById(id);
        return MessageResponse.create("Deleted movement with ID " + id);
    }

    private Movement verifyIfExists(Long id) throws EntityNotFoundException {
        return this.movementRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Movement", id));
    }
}