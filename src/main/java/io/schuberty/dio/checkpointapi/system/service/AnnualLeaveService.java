package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.AnnualLeave;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.repository.AnnualLeaveRepository;
import io.schuberty.dio.checkpointapi.system.utils.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnnualLeaveService {
    
    private AnnualLeaveRepository annualLeaveRepository;

    public MessageResponseDTO create(AnnualLeave annualLeave) {
        AnnualLeave createdAnnualLeave = this.annualLeaveRepository.save(annualLeave);
        return MessageResponse.create("Created annualLeave with ID " + createdAnnualLeave.getId());
    }

    public List<AnnualLeave> listAll() {
        return this.annualLeaveRepository.findAll();
    }
    
    public AnnualLeave findById(Long id) throws EntityNotFoundException {
        AnnualLeave annualLeave = verifyIfExists(id);
        return annualLeave;
    }

    public MessageResponseDTO updateById(Long id, AnnualLeave annualLeave) throws EntityNotFoundException {
        verifyIfExists(id);
        AnnualLeave updatedAnnualLeave = this.annualLeaveRepository.save(annualLeave);
        return MessageResponse.create("Updated annualLeave with ID " + updatedAnnualLeave.getId());
    } 

    public MessageResponseDTO delete(Long id) throws EntityNotFoundException {
        verifyIfExists(id);
        this.annualLeaveRepository.deleteById(id);
        return MessageResponse.create("Deleted annualLeave with ID " + id);
    }

    private AnnualLeave verifyIfExists(Long id) throws EntityNotFoundException {
        return this.annualLeaveRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("AnnualLeave", id));
    }
}