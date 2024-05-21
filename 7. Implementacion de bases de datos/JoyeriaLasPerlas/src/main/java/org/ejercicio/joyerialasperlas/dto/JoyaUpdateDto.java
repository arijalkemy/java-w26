package org.ejercicio.joyerialasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class JoyaUpdateDto {
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String material;
    @NotNull
    @Min(1)
    private Integer peso;
    @NotEmpty
    private String particularidad;
    @NotNull
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;
    @NotNull
    private Boolean ventaONo;
}
