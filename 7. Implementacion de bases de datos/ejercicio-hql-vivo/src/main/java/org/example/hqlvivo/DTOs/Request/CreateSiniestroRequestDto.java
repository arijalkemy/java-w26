package org.example.hqlvivo.DTOs.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSiniestroRequestDto {
    private LocalDate fecha;
    private Double perdida;
    private Long vehiculo_id;
}
