package io.schuberty.dio.checkpointapi.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.schuberty.dio.checkpointapi.model.checkpoint.UserCategory;

@Repository
public interface UserCategoryRepository extends JpaRepository<UserCategory, Long> { }