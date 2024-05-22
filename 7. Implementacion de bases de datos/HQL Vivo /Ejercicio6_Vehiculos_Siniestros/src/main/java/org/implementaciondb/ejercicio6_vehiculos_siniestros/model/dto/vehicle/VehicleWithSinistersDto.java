package org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.sinister.SinisterResponseDto;
import org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.sinister.SinisterWithoutVehicleDto;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleWithSinistersDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("patent")
    private String patent;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("manufacture_year")
    private Integer manufactureYear;

    @JsonProperty("number_of_wheels")
    private Integer numberOfWheels;

    @JsonProperty("sinisters")
    private List<SinisterWithoutVehicleDto> sinisters;

}
