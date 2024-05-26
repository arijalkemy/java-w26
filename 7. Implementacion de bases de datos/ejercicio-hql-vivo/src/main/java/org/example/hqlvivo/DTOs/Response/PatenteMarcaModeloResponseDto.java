package org.example.hqlvivo.DTOs.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatenteMarcaModeloResponseDto {
    private String patente;
    private String marca;
    private String modelo;
}
