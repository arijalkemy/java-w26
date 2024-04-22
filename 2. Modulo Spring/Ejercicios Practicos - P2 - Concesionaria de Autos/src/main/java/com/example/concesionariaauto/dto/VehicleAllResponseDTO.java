package com.example.concesionariaauto.dto;

import com.example.concesionariaauto.entity.ServiceEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class VehicleAllResponseDTO {
    private UUID id;
    private String brand;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate manofacturingDate;
    private int numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    @JsonSerialize(contentAs = ServiceEntity.class)
    @JsonDeserialize(contentAs = ServiceEntity.class)
    private List<ServiceEntity> services;
    private int countOfOwners;
}
