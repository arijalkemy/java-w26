package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El campo de la materia no puede estar vacio")
    @Pattern(regexp = "[A-Z].*", message = "El nombre de la materia debe comenzar con mayuscula")
    @Size(max=3, message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;

    @PositiveOrZero(message = "La nota minima es 0.0")
    @Max(value = 10, message = "La nota maxima es 10.0")
    Double score;
}
