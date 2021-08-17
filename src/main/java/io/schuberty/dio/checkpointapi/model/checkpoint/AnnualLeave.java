package io.schuberty.dio.checkpointapi.model.checkpoint;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
public class AnnualLeave {
    
    @EmbeddedId
    private AnnualLeaveId id;

    private LocalDate dateWorked;

    private BigDecimal amountHoursWorked;

    private BigDecimal balanceHoursWorked;

    @Getter
    @Setter
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class AnnualLeaveId implements Serializable {
        private Long annualLeaveId;
        private Long movementId;
        private Long userId;
    }
}