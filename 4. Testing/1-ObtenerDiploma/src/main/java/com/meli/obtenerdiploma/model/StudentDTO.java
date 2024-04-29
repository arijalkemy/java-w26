package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "The name of student must not be empty")
    @NotNull
    String studentName;
    String message;
    Double averageScore;
    @NotNull
    @Valid
    List<SubjectDTO> subjects;
}
