package org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.sinister;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle.VehicleResponseDto;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SinisterResponseDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("sinister_date")
    private LocalDate sinisterDate;

    @JsonProperty("economic_loss")
    private Double economicLoss;

    @JsonProperty("vehicle")
    private VehicleResponseDto vehicle;

}
