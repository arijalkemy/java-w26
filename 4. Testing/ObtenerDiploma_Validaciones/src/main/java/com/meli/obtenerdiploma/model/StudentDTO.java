package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull (message = "The student name cannot be null")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The student name have to start whit Uppercase.")
    @Size(max = 50, message = "The student name length cannot be higher than 50 characters.")
    @NotEmpty(message = "The Student name cannot be empty")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    @NotNull (message = "The student subjects cannot be null")
    @NotEmpty (message = "The Student subjects cannot be empty")
    List<SubjectDTO> subjects;
}
