package org.example.integradorvehiculossiniestros.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class VehicleRequestDTO {
    private String plate;
    private String brand;
    private String model;
    private LocalDateTime fabricationDate;
    private Integer wheels;
}
