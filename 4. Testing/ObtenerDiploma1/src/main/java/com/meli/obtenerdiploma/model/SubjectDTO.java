package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacio")
    @Size(min = 2, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;
    @NotNull
    @Min(value = 0, message = "La minima nota es 0.0")
    @Max(value = 10, message = "La maxima nota es 10.0")
    Double score;
}
