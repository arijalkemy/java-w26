package org.implementaciondb.vehiculos_siniestros.model.dto.sinister;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SinisterRequestDto {

    @NotNull(message = "Sinister_date es requerido")
    @JsonProperty("sinister_date")
    private LocalDate sinisterDate;

    @NotNull(message = "Economic_loss es requerido")
    @JsonProperty("economic_loss")
    private Double economicLoss;

    @NotNull(message = "vehicle_id es requerido")
    @JsonProperty("vehicle_id")
    private Long vehicleId;
}
