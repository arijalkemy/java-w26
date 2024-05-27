package com.mercadolibre.Vehiculos_Sinietros.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequestDto {
    private String patente;
    private String marca;
    private String modelo;
    private LocalDate año_fabricacion;
    private Integer cant_ruedas;
}
