package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del nombre no pouede superar los 30 caracteres")
    String name;

    @DecimalMin(value = "0.0", message = "La nota minima es 0.0")
    @DecimalMax(value = "10.0", message = "La nota maxima es 10.0")
    Double score;
}
