package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.UserCategory;
import io.schuberty.dio.checkpointapi.system.repository.UserCategoryRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserCategoryService {

    private UserCategoryRepository categoryRepository;

    public List<UserCategory> listAll() {
        return this.categoryRepository.findAll();
    }
    
    public UserCategory findById(Long id) throws EntityNotFoundException {
        UserCategory user = verifyIfExists(id);
        return user;
    }

    private UserCategory verifyIfExists(Long id) throws EntityNotFoundException {
        return this.categoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("User Category", id));
    }
}