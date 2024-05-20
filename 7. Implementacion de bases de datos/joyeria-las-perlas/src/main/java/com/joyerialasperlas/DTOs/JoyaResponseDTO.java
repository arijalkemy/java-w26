package com.joyerialasperlas.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JoyaResponseDTO {
    Long id;
    String nombre;
    String material;
    Integer peso;
    String particularidad;
    @JsonProperty("posee_piedra")
    Boolean poseePiedra;
    Boolean ventaONo;
}
