package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@ToString
public class StudentDTO {
    
    @NotBlank(message = "The value of student name no should be null")
    @NotNull
    String studentName;


    String message;

    @Positive
    Double averageScore;

    @Size(min = 1)
    List< @Valid SubjectDTO> subjects;
}
