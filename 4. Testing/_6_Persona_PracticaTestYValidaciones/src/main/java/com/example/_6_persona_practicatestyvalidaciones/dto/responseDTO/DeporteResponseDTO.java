package com.example._6_persona_practicatestyvalidaciones.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeporteResponseDTO {
    private String nombre;
    private int nivel;
}
