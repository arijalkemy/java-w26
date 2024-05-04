package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*$", message="El nombre del alumno debe comenzar en mayuscula")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @NotNull(message = "El nombre del alumno no puede estar vacío")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede estar vacía")
    List<@Valid SubjectDTO> subjects;
}
