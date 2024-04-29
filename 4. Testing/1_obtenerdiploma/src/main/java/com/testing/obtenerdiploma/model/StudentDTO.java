package com.testing.obtenerdiploma.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "[A-Z]\\w*", message = "El nombre del alumno debe comenzar con mayúscula.")
    String studentName;

    String message;
    Double averageScore;

    @Size(min = 1, message = "La lista no puede ser vacía.")
    @NotNull(message = "subjects no debe ser nulo")
    @Valid
    List<SubjectDTO> subjects;
}
