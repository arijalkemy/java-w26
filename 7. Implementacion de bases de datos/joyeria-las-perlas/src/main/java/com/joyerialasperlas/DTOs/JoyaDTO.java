package com.joyerialasperlas.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JoyaDTO {
    String nombre;
    String material;
    Integer peso;
    String particularidad;
    @JsonProperty("posee_piedra")
    Boolean poseePiedra;
    Boolean ventaONo;
}
