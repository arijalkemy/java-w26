package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull
    String studentName;
    @NotEmpty
    String message;
    @NotEmpty
    Double averageScore;
    @NotEmpty
    List<SubjectDTO> subjects;
}
