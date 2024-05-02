package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del estudiante no puede estar vacío")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del estudiante debe comenzar con mayúscula")
    @Size(max = 50, message = "El nombre del estudiante no puede tener más de 50 caracteres")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacía")
    List<@Valid SubjectDTO> subjects;
}
