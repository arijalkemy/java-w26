package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede ser vacio")
    String name;

    @PositiveOrZero(message = "La nota no puede ser negativa")
    @Max(value = 10, message = "La nota excede el limite (maximo 10)")
    Double score;
}
