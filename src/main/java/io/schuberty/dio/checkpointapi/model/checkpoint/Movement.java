package io.schuberty.dio.checkpointapi.model.checkpoint;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movement {

    @EmbeddedId
    private MovementId id;

    private LocalDate entryDate;

    private LocalDate exitDate;

    private BigDecimal period;

    @ManyToOne
    private Occurrence occurrence;

    @ManyToOne
    private Calendar calendar;

    @Getter
    @Setter
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class MovementId implements Serializable {

        private Long movementId;
        private Long userId;
    }
}