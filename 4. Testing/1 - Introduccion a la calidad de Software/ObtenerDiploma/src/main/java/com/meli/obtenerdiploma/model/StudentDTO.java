package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no puede estar vacio")
    @Pattern(regexp = "[A-Z].*", message = "El nombre del alumno debe comenzar con mayuscula")
    @Size(max=50, message = "La longitud del nombre no puede superar los 50 caracteres")
    String studentName;

    String message;
    Double averageScore;
    @Size(min = 1, message = "La lista no puede ser vacia")
    List<SubjectDTO> subjects;
}
