package com.meli.obtenerdiploma.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {


    @NotNull(message = "El campo nombre del alumno no puede estar vacío")
    @Pattern(regexp = "[A-Z].*", message = "El nombre del estudiante debe iniciar con mayúscula")
    @Size(min = 1, max = 50, message = "El nombre no puede ser más de 50 caracteres de largo")
    String studentName;

    String message;
    Double averageScore;

    @NotNull(message = "La lista de materias no puede estar vacía")
    @Valid
    List<SubjectDTO> subjects;
}
