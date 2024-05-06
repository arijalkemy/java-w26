package com.example._6_persona_practicatestyvalidaciones.dto.requestDTO;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeporteRequestDTO {
    @NotBlank(message = "El nombre no puede estar vacio")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre debe comenzar con mayuscula")
    private String nombre;

    @NotNull(message = "El nivel no puede estar vacio")
    @Positive(message = "El nivel debe ser positivo")
    @Min(value = 1, message = "El nivel debe ser mayor o igual a 1")
    @Max(value = 10, message = "El nivel debe ser menor o igual a 10")
    private Integer nivel;
}
