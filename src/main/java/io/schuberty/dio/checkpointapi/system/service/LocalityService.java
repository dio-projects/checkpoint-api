package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.Locality;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.repository.LocalityRepository;
import io.schuberty.dio.checkpointapi.system.utils.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LocalityService {
    
    private LocalityRepository localityRepository;

    public MessageResponseDTO create(Locality locality) {
        Locality createdLocality = this.localityRepository.save(locality);
        return MessageResponse.create("Created locality with ID " + createdLocality.getId());
    }

    public List<Locality> listAll() {
        return this.localityRepository.findAll();
    }
    
    public Locality findById(Long id) throws EntityNotFoundException {
        Locality locality = verifyIfExists(id);
        return locality;
    }

    public MessageResponseDTO updateById(Long id, Locality locality) throws EntityNotFoundException {
        verifyIfExists(id);
        Locality updatedLocality = this.localityRepository.save(locality);
        return MessageResponse.create("Updated locality with ID " + updatedLocality.getId());
    } 

    public MessageResponseDTO delete(Long id) throws EntityNotFoundException {
        verifyIfExists(id);
        this.localityRepository.deleteById(id);
        return MessageResponse.create("Deleted locality with ID " + id);
    }

    private Locality verifyIfExists(Long id) throws EntityNotFoundException {
        return this.localityRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Locality", id));
    }
}