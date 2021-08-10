package io.schuberty.dio.checkpointapi.model.checkpoint;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
public class Movement {

    @EmbeddedId
    private MovementId id;

    private LocalDateTime entryDate;

    private LocalDateTime exitDate;

    private BigDecimal period;

    private Occurrence occurrence;

    private Calendar calendar;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class MovementId implements Serializable {

        private Long movementId;
        private Long userId;
    }
}