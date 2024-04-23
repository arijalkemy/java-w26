package com.mercadolibre.ConcecionariaAutos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceVehicle {
    private LocalDate date;
    private Integer kilometers;
    private String descriptions;
}
