package org.responseentity.agenciaautos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.responseentity.agenciaautos.entity.ServiceEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleDTOWithServices {
    private UUID id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    private List<ServiceEntity> services;
    private String countOfOwners;
}
