package org.example.ejercicio_concesionario.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@JsonIgnoreProperties (ignoreUnknown = true)
public class CarResponseDTO {
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
}
