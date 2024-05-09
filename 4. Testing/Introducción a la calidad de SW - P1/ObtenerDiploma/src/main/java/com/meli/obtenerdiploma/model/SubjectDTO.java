package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vació.")
            @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia deebe comenzar con mayúscula.")
            @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;

    @NotNull
    @Min(value = 0, message = "El valor debe ser mayor a 0")
    @Max(value = 10, message = "El valor debe estar entre 1 y 10")
    Double score;
}
