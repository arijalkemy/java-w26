package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter @Valid
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp = "^[^a-z].*$",message = "El nombre debe iniciar en mayuscula")
    @Size(max = 30,message = "No puede ser mayor a 30 caracteres")
    String name;
    @NotNull(message = "La nota no puede estar vacia")
    @Min(value = 0,message="La nota minima es 0.0")
    @Max(value = 10,message = "la nota maxima es 10.0")
    Double score;
}
