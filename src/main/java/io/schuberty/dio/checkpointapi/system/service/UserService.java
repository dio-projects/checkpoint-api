package io.schuberty.dio.checkpointapi.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.schuberty.dio.checkpointapi.exception.UserNotFoundException;
import io.schuberty.dio.checkpointapi.model.User;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.repository.UserRepository;
import io.schuberty.dio.checkpointapi.system.utils.MessageResponse;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    
    private UserRepository userRepository;

    public MessageResponseDTO create(User user) {
        User createdUser = this.userRepository.save(user);
        return MessageResponse.create("Created user with ID " + createdUser.getId());
    }

    public List<User> listAll() {
        return this.userRepository.findAll();
    }
    
    public User findById(Long id) throws UserNotFoundException {
        User user = verifyIfExists(id);
        return user;
    }

    public MessageResponseDTO updateById(Long id, User user) throws UserNotFoundException {
        verifyIfExists(id);
        User updatedUser = this.userRepository.save(user);
        return MessageResponse.create("Updated user with ID " + updatedUser.getId());
    } 

    public MessageResponseDTO delete(Long id) throws UserNotFoundException {
        verifyIfExists(id);
        this.userRepository.deleteById(id);
        return MessageResponse.create("Deleted user with ID " + id);
    }

    private User verifyIfExists(Long id) throws UserNotFoundException {
        return this.userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
    }
}