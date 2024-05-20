package org.ejercicio.joyerialasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JoyaResponseDto {
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
