package io.schuberty.dio.checkpointapi.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}