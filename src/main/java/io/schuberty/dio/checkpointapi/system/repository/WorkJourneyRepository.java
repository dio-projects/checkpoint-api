package io.schuberty.dio.checkpointapi.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.schuberty.dio.checkpointapi.model.checkpoint.WorkJourney;

@Repository
public interface WorkJourneyRepository extends JpaRepository<WorkJourney, Long> { }