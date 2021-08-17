package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.AccessLevel;
import io.schuberty.dio.checkpointapi.system.repository.AccessLevelRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AccessLevelService {

    private AccessLevelRepository accessLevelRepository;

    public List<AccessLevel> listAll() {
        return this.accessLevelRepository.findAll();
    }
    
    public AccessLevel findById(Long id) throws EntityNotFoundException {
        AccessLevel user = verifyIfExists(id);
        return user;
    }

    private AccessLevel verifyIfExists(Long id) throws EntityNotFoundException {
        return this.accessLevelRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Access Level", id));
    }
}