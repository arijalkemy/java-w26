package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @NotBlank(message = "El nombre del estudiante no puede estar vacio.")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    @Pattern(regexp="[A-Z].*",
            message = "El nombre del estudiante debe comenzar con mayúscula.")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacia")
    List<@Valid SubjectDTO> subjects;
}
