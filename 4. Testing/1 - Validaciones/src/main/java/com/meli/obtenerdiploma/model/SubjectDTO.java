package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*",message = "El nombre de la materia debe comenzar con mayúscula")
    @Size(max = 30, message = "El nombre de la materia no puede tener más de 30 caracteres")
    String name;

    @NotNull(message = "La nota de la materia no puede estar vacía")
    @Min(value = 0, message = "La nota minima es 0.0")
    @Max(value = 10, message = "La nota maxima es 10.0")
    Double score;
}
