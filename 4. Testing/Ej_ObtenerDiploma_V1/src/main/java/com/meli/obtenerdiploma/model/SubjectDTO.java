package com.meli.obtenerdiploma.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$", message = "El nombre de la materia debe empezar con mayúscula")
    @Size(max = 30,message = "El nombre no puede superar los 30 caracteres")
    String name;
    @DecimalMin(value = "0.0", inclusive = false, message = "El valor debe ser mayor que 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "El valor debe ser menor o igual a 10.0" )
    Double score;
}
