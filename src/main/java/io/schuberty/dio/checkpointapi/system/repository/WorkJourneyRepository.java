package io.schuberty.dio.checkpointapi.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.schuberty.dio.checkpointapi.model.checkpoint.WorkJourney;

public interface WorkJourneyRepository extends JpaRepository<WorkJourney, Long> { }