package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacío")
    @Size(max = 50, message = "El nombre del alumno no puede superar los 50 caracteres")
    @Pattern(regexp = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*$", message = "El nombre del alumno debe comenzar con mayúscula")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    @NotEmpty(message = "La lista no puede ser vacía")
    List<SubjectDTO> subjects;
    
}
