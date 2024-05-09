package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter @Setter
@Valid
public class StudentDTO {
    String studentName;
    String message;
    Double averageScore;
    List<SubjectDTO> subjects;
}
