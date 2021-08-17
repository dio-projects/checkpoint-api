package io.schuberty.dio.checkpointapi.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.schuberty.dio.checkpointapi.model.checkpoint.AccessLevel;

@Repository
public interface AccessLevelRepository extends JpaRepository<AccessLevel, Long> { }