package com.mercadolibre.lasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoyaRequestDTO {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
}
