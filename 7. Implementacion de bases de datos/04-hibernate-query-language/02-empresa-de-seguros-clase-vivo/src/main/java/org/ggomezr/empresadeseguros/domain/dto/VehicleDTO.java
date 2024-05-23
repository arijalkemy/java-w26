package org.ggomezr.empresadeseguros.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ggomezr.empresadeseguros.domain.model.Sinister;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDTO {
    private Integer id;
    private String patent;
    private String brand;
    private String model;
    private Integer fabricationYear;
    private Integer numberOfWheels;
}
