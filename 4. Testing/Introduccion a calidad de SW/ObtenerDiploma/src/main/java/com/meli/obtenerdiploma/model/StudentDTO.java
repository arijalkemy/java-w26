package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede ser vacío.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno tiene que comenzar con mayúscula.")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    @NotEmpty(message = "La lista no puede ser vacía.")
    List<SubjectDTO> subjects;
}
