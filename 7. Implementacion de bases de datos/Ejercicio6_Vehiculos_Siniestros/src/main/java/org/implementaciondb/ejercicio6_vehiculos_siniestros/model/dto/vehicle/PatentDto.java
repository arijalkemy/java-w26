package org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatentDto {

    @JsonProperty("patent")
    private String patent;

}
