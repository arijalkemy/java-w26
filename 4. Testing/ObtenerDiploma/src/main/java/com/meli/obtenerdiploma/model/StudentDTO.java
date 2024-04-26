package com.meli.obtenerdiploma.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "Este campo es requerido")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "Este campo no debe estar vacio")
    List<@Valid SubjectDTO> subjects;
}
