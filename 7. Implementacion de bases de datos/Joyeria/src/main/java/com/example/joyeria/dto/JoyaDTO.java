package com.example.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JoyaDTO {
    @JsonIgnore
    private Long id;
    private String nombre;
    private String material;
    private Long peso;
    private String particularidad;
    private Boolean posee_piedra;
    @JsonIgnore
    private Boolean ventaONo;
}
