package org.responseentity.lasperlas.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoyaDTO {
    private Long nro_identificatorio;

    @NotNull
    @NotEmpty(message = "el campo nombre no puede estar vacio")
    @NotBlank(message = "el campo nombre no puede estar vacio")
    private String nombre;

    @NotNull
    @NotEmpty(message = "el campo material no puede estar vacio")
    @NotBlank(message = "el campo material no puede estar vacio")
    @Pattern(regexp = "^(Oro|Plata|Diamante|oro|plata|diamante)$", message = "El material debe ser Oro, Plata o Diamante")
    private String material;

    @NotNull
    @Positive(message = "el campo de peso no puede ser menor a cero")
    private Integer peso;

    @NotNull
    @NotEmpty(message = "el campo particularidad no puede estar vacio")
    @NotBlank(message = "el campo particularidad no puede estar vacio")
    private String particularidad;

    private Boolean posee_piedra;
    private Boolean ventaONo;
}
