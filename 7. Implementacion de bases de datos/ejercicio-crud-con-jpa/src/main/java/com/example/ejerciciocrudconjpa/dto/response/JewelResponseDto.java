package com.example.ejerciciocrudconjpa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class JewelResponseDto {
    private Integer nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;

    @Override
    public String toString() {
        return " {" +
            "nroIdentificatorio = " + nroIdentificatorio +
            ", nombre = '" + nombre + '\'' +
            ", material = '" + material + '\'' +
            ", peso = " + peso +
            ", particularidad = '" + particularidad + '\'' +
            ", poseePiedra = " + poseePiedra +
            ", ventaONo = " + ventaONo +
            '}';
    }
}
