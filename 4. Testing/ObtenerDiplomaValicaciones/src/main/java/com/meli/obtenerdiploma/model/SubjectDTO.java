package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayusculas")
    @Size(max = 30, message = "El nombre de la materia no puede tener más de 30 caracteres")
    String name;
    @NotNull(message = "El score de la materia no puede estar vacío")
    @Min(value = 0, message = "El score de la materia no puede ser negativo")
    @Max(value = 10, message = "El score de la materia no puede ser mayor a 10")
    Double score;
}
