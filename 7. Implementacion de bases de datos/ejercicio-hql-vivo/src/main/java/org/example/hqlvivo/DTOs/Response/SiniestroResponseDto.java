package org.example.hqlvivo.DTOs.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroResponseDto {
    private Long id;
    private LocalDate fecha;
    private Double perdida;
    private VehiculoResponseDto vehiculo;
}
