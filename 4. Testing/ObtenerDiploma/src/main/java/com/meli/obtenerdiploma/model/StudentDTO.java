package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Max(value = 50, message = "El nombre del alumno no debe exceder los 50 caracteres.")
    @Pattern(regexp = "^[A-Z].*$",
            message = "El nombre del alumno debe empezar con mayúscula.",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty
    List<SubjectDTO> subjects;
}
