package com.bootcamp.diploma.model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter
public class StudentDTO implements Serializable {
    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayuscula")
    String studentName;
    @NotEmpty(message = "La lista no puede ser vacia")
    @Valid
    List<SubjectDTO> subjects;

    String message;
    Double averageScore;
}
