package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class SubjectDTO {
    //No nulo ni espacios en blancos
    @NotBlank
    //Tamaño minimo de 2 y maximo de 50
    @Size(min = 2, max = 50)
    String name;

    //Score minimo de 0
    @Min(0)
    Double score;
}
