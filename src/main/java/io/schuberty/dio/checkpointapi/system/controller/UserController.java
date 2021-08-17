package io.schuberty.dio.checkpointapi.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.schuberty.dio.checkpointapi.exception.EntityNotFoundException;
import io.schuberty.dio.checkpointapi.model.User;
import io.schuberty.dio.checkpointapi.system.dto.response.MessageResponseDTO;
import io.schuberty.dio.checkpointapi.system.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserService userService;

    @ApiOperation(value = "Create a user and returns its ID")
    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createUser(@RequestBody User user) {
        return this.userService.create(user);
    }

    @ApiOperation(value = "Return all users")
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<User> listAll() {
        return this.userService.listAll();
    }

    @ApiOperation(value = "Return a user by giving an ID")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.userService.findById(id);
    }

    @ApiOperation(value = "Update a user by giving an ID")
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody User user) throws EntityNotFoundException {
        return this.userService.updateById(id, user);
    }

    @ApiOperation(value = "Delete a user by giving an ID")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return this.userService.delete(id);
    }
}