package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de las materias debe ser válido")
    String name;

    @PositiveOrZero(message = "La nota de las materias debe ser >= 0")
    Double score;
}
