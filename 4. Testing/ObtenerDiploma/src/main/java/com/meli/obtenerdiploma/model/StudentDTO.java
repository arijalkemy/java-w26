package com.meli.obtenerdiploma.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "Student name cannot be blank")
    String studentName;
    String message;
    Double averageScore;
    @NotNull(message = "Subjects cannot be null")
    @NotEmpty(message = "Subjects cannot be empty")
    @Valid
    List<SubjectDTO> subjects;
}
