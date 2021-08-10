package io.schuberty.dio.checkpointapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.schuberty.dio.checkpointapi.model.checkpoint.AccessLevel;
import io.schuberty.dio.checkpointapi.model.checkpoint.Company;
import io.schuberty.dio.checkpointapi.model.checkpoint.WorkJourney;
import io.schuberty.dio.checkpointapi.model.checkpoint.UserCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserCategory userCategory;

    private String name;

    @ManyToOne
    private Company company;

    @ManyToOne
    private AccessLevel accessLevel;

    @ManyToOne
    private WorkJourney workJourney;

    private BigDecimal delayTolerance;

    private LocalDateTime beginJourney;

    private LocalDateTime endJourney;
}