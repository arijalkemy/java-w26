package com.example.siniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestroDto {
    private List<PatenteMarcaModeloDto> vehiculo;
    private Double perdida;
}
