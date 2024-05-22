package org.ggomezr.empresadeseguros.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ggomezr.empresadeseguros.domain.model.Vehicle;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SinisterDTO {
    private Long id;
    private LocalDate sinisterDate;
    private Double economicLoss;
    private VehicleDTO reportedVehicle;
}
