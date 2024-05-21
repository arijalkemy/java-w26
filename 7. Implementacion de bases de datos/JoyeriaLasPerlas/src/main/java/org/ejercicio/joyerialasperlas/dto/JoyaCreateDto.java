package org.ejercicio.joyerialasperlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class JoyaCreateDto {
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
    @AssertTrue(message = "Para crear una joya debe estar en venta")
    private Boolean ventaONo;
}
