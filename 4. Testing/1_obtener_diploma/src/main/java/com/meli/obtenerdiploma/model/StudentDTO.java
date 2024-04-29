package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Getter @Setter
public class StudentDTO {

    @NotNull(message = "Student Name should not be null")
    String studentName;
    String message;
    Double averageScore;
    List<@Valid SubjectDTO> subjects;
}
