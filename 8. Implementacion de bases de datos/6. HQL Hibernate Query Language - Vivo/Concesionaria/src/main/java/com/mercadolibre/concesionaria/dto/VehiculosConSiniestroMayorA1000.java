package com.mercadolibre.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculosConSiniestroMayorA1000 {
    private List<PatenteMarcaYModeloVehiculoDTO> vehiculos;
    private Double sumaSiniestros;
}
