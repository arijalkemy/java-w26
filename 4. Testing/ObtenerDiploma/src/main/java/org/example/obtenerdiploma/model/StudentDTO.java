package org.example.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @NotNull(message = "El nombre del estudiante no puede ser nulo")
    @NotBlank(message = "El nombre del estudiante no puede ser vacío")
    @Max(value = 50, message = "El nombre del estudiante no puede tener más de 50 caracteres")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del estudiante debe comenzar con una letra mayúscula")
    String studentName;
    @NotNull(message = "El mensaje no puede ser nulo")
    @NotEmpty(message = "El mensaje no puede ser vacío")
    String message;
    Double averageScore;
    @NotNull(message = "La lista de materias no puede ser nula")
    @NotEmpty(message = "La lista de materias no puede ser vacía")
    List<SubjectDTO> subjects;
}
