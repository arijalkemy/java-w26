package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "el campo de nombre es requerido")
    @Size(min=3, message = "el campo de nombre no puede ser menor a 3 caracteres")
    String name;

    @NotEmpty(message = "el campo de score es requerido")
    @PositiveOrZero(message = "el campo de score debe ser positivo o cero")
    Double score;
}
