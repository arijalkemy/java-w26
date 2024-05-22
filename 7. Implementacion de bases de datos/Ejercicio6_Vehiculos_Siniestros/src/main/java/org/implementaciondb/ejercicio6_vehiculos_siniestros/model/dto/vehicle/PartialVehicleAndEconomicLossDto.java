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
public class PartialVehicleAndEconomicLossDto {

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("patent")
    private String patent;

    @JsonProperty("economic_loss")
    private Double economicLoss;

}
