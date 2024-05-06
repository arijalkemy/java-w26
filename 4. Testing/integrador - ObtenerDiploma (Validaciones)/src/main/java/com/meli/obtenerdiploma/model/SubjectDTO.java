package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {

    @NotNull(message = "El campo name no puede ir vacío")
    @Pattern(regexp = "[A-Z].*", message = "El nombre debe iniciar con mayúscula")
    @Size(min = 1, max = 30, message = "El mensaje no puede ser más de 30 caracteres de largo" )
    String name;

    @NotNull(message = "El campo score no puede ir vacío")
    @DecimalMin(value = "0.0", message = "La nota mínima es 0.0")
    @DecimalMax(value = "10.0", message = "La nota máxima es 10.0")
    Double score;
}
