package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Getter @Setter
public class StudentDTO {

    @NotNull
    String studentName;

    String message;

    @Max(value = 10, message = "Not a valid score")
    @Min(value = 0, message = "Not a valid score")
    Double averageScore;

    @NotNull
    @Valid
    List<SubjectDTO> subjects;
}
