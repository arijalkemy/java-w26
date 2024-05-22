package org.implementaciondb.ejercicio6_vehiculos_siniestros.model.dto.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequestDto {

    @NotBlank(message = "patent es requerido")
    @JsonProperty("patent")
    private String patent;

    @NotBlank(message = "Brand es requerido")
    private String brand;

    @NotBlank(message = "Model es requerido")
    private String model;

    @NotNull(message = "Manufacture es requerido")
    @JsonProperty("manufacture_year")
    private Integer manufactureYear;

    @NotNull(message = "Number of wheels es requerido")
    @JsonProperty("number_of_wheels")
    private Integer numberOfWheels;

}
