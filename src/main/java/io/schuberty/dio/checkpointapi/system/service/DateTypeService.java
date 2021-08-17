package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.DateType;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.repository.DateTypeRepository;
import io.schuberty.dio.checkpointapi.system.utils.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DateTypeService {
    
    private DateTypeRepository dateTypeRepository;

    public MessageResponseDTO create(DateType dateType) {
        DateType createdDateType = this.dateTypeRepository.save(dateType);
        return MessageResponse.create("Created dateType with ID " + createdDateType.getId());
    }

    public List<DateType> listAll() {
        return this.dateTypeRepository.findAll();
    }
    
    public DateType findById(Long id) throws EntityNotFoundException {
        DateType dateType = verifyIfExists(id);
        return dateType;
    }

    public MessageResponseDTO updateById(Long id, DateType dateType) throws EntityNotFoundException {
        verifyIfExists(id);
        DateType updatedDateType = this.dateTypeRepository.save(dateType);
        return MessageResponse.create("Updated dateType with ID " + updatedDateType.getId());
    } 

    public MessageResponseDTO delete(Long id) throws EntityNotFoundException {
        verifyIfExists(id);
        this.dateTypeRepository.deleteById(id);
        return MessageResponse.create("Deleted dateType with ID " + id);
    }

    private DateType verifyIfExists(Long id) throws EntityNotFoundException {
        return this.dateTypeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Date Type", id));
    }
}