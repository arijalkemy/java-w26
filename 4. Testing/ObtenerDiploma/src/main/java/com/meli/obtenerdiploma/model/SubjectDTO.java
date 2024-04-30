package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "el campo de name es requerido")
    @NotBlank(message = "el campo de name no puede estar vacio")
    @NotBlank(message = "el campo de name no puede estar vacio")
    String name;

    @NotNull(message = "el campo de score es requerido")
    @PositiveOrZero(message = "el campo de score debe de ser positivo o cero")
    Double score;
}
