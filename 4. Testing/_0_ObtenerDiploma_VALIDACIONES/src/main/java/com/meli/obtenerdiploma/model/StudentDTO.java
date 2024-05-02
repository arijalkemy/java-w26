package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacio")
    @Max(value = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe empezar con mayuscula")
    String studentName;

    String message;
    Double averageScore;


    @NotEmpty(message = "La lista no puede estar vacia")
    List<@Valid SubjectDTO> subjects;
}
