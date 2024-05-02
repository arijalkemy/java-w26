package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank (message = "El nombre de la materia no puede estar vacio")
    @Size(max = 30, message = "El nombre de la materia no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
    String name;

    @NotNull(message = "La nota no puede estar vacia")
    @DecimalMax(value = "10.0", message = "La nota maxima es 10.0")
    @DecimalMin(value = "0.0", message = "La nota minima es de 0.0")
    Double score;
}
