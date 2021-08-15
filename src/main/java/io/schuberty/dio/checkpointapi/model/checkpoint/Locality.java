package io.schuberty.dio.checkpointapi.model.checkpoint;

import java.io.Serializable;

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
public class Locality {

    @EmbeddedId    
    private LocalityId id;

    @ManyToOne
    private AccessLevel accessLevel;

    private String description;

    @Getter
    @Setter
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class LocalityId implements Serializable {

        private Long localityId;
        private Long accessLevelId;
    }
}