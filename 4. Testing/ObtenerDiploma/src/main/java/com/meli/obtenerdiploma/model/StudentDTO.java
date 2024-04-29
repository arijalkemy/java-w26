package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del estudiante debe ser válido")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "Debe haber al menos una materia registrada")
    List<@Valid SubjectDTO> subjects;
}
