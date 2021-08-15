package io.schuberty.dio.checkpointapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

import io.schuberty.dio.checkpointapi.model.checkpoint.AccessLevel;
import io.schuberty.dio.checkpointapi.model.checkpoint.Company;
import io.schuberty.dio.checkpointapi.model.checkpoint.UserCategory;
import io.schuberty.dio.checkpointapi.model.checkpoint.WorkJourney;
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
@Audited
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private UserCategory userCategory;

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