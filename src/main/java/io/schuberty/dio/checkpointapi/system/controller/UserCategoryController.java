package io.schuberty.dio.checkpointapi.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.schuberty.dio.checkpointapi.exception.CategoryNotFoundException;
import io.schuberty.dio.checkpointapi.model.checkpoint.UserCategory;
import io.schuberty.dio.checkpointapi.system.service.UserCategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/usercategory")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserCategoryController {

    private UserCategoryService categoryService;

    @ApiOperation(value = "Return all user categorys")
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<UserCategory> listAll() {
        return this.categoryService.listAll();
    }

    @ApiOperation(value = "Return a user category by giving an ID")
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserCategory findById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return this.categoryService.findById(id);
    }
}