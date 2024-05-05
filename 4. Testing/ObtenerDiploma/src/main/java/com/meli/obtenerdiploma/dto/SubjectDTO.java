package com.meli.obtenerdiploma.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp = "[A-Z].*",message = "el nombre de la materia debe empezar en mayuscula")
    @Size(max = 30, message = "la longitud del nombre no puede superar los 30 caracteres")
    String name;
    @NotNull(message = "la nota no puede estar vacia")
    @DecimalMin(value = "0.0", message = "la nota minima es 0")
    @DecimalMax(value = "10.0", message = "la nota maxima es 10")
    Double score;
}
