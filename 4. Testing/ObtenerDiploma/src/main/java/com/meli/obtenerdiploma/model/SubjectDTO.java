package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de las materias debe ser válido")
    String name;

    @Min(value = 0, message = "La nota debe ser >= 0") @Max(value = 10, message = "La nota debe ser <= 10")
    Double score;
}
