package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "el nombre de la materia no puede estar vacio.")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre de la materia debe comenzar con mayuscula.")
    @Size(max=30,message = "La longitud del nombre no debe superar los 30 caracteres." )
    String name;
    @NotNull(message = "la nota no puede estar vacia")
    @DecimalMin(value = "0.0", message = "la minima nota es 0.0")
    @DecimalMax(value = "10.0", message = "la maxima nota es 10.0")
    Double score;
}
