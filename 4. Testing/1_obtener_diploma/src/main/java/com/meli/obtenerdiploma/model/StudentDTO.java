package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Getter @Setter
public class StudentDTO {

    @NotNull(message = "El nombre del alumno no puede estar vacio.")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre del alumno debe comenzar con mayuscula.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista de materias no debe estar vacia")
    List<@Valid SubjectDTO> subjects;
}
