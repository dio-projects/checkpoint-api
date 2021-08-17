package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.CompanyNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.Company;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.repository.CompanyRepository;
import io.schuberty.dio.checkpointapi.system.utils.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyService {

    private CompanyRepository companyRepository;

    public MessageResponseDTO create(Company company) {
        Company createdCompany = this.companyRepository.save(company);
        return MessageResponse.create("Company created with ID " + createdCompany.getId());
    }

    public List<Company> listAll() {
        return this.companyRepository.findAll();
    }
    
    public Company findById(Long id) throws CompanyNotFoundException {
        Company company = verifyIfExists(id);
        return company;
    }

    public MessageResponseDTO updateById(Long id, Company company) throws CompanyNotFoundException {
        verifyIfExists(id);
        Company updatedCompany = this.companyRepository.save(company);
        return MessageResponse.create("Updated company with ID " + updatedCompany.getId());
    } 

    public MessageResponseDTO delete(Long id) throws CompanyNotFoundException {
        verifyIfExists(id);
        this.companyRepository.deleteById(id);
        return MessageResponse.create("Deleted company with ID " + id);
    }

    private Company verifyIfExists(Long id) throws CompanyNotFoundException {
        return this.companyRepository.findById(id)
            .orElseThrow(() -> new CompanyNotFoundException(id));
    }

    
}