package com.meli.obtenerdiploma.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacio")
    @Pattern(regexp = "[A-Z].*",message = "el nombre del alumno debe empezar en mayuscula")
    @Size(max = 50, message = "el nombre del alumno no puede superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede estar vacia")
    @Valid
    List<SubjectDTO> subjects;
}
