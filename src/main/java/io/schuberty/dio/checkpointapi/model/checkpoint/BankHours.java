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
public class BankHours {
    
    @EmbeddedId
    private BankHoursId id;

    private LocalDateTime dateWorked;

    private BigDecimal amountHoursWorked;

    private BigDecimal balanceHoursWorked;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class BankHoursId implements Serializable {
        private Long bankHoursId;
        private Long movementId;
        private Long userId;
    }
}