package com.meli.obtenerdiploma.model;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    @NotNull(message="studentName field is required")
    @Size(min = 2, max = 50, message="El nombre del estudiante debe de ser mayor de dos caracteres y menor que 50")
    @Pattern(regexp = "^[A-Z].*$", message="El nombre del estudiante debe de comenzar con mayuscula")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    @NotEmpty(message="Subjects list must contain something")
    List<SubjectDTO> subjects;
}
