package org.implementaciondb.vehiculos_siniestros.model.dto.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiclesSinistersWithTotalLossDTO {
    private List<VehicleQueriesDTO> vehicles;
    private Double totalLoss;

}
