package com.ejercicio.segurosdeautos.DTO;

import com.ejercicio.segurosdeautos.model.Sinister;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDTO {
    private Long id;
    private String patent;
    private String brand;
    private String model;
    private Integer febricationYear;
    private Integer wheels;
    private Double economicLost; // Nuevo campo para la pérdida económica total
    private List<Sinister> reported;
}