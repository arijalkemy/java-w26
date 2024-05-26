package org.example.hqlvivo.DTOs.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoResponseDto {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    private Integer cantRuedas;
}
