package org.implementaciondb.vehiculos_siniestros.model.dto.sinister;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SinisterWithoutVehicleDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("sinister_date")
    private LocalDate sinisterDate;

    @JsonProperty("economic_loss")
    private Double economicLoss;

}
