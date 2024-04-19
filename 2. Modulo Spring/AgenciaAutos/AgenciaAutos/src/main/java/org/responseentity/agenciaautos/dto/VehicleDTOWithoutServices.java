package org.responseentity.agenciaautos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDTOWithoutServices {
    private UUID id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    private String countOfOwners;
}
