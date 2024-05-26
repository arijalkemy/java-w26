package org.example.hqlvivo.DTOs.Response;

import lombok.Data;

@Data
public class PatenteMarcaModeloTotalPerdidaResponseDto {
    private String patente;
    private String marca;
    private Double totalPerdida;
}
