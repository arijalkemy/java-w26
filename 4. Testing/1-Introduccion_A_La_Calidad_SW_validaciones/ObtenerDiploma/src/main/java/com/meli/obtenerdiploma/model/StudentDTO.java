package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El campo no puede ser nulo")
    @Pattern(regexp="^[^a-z].*$",message = "El nombre debe iniciar en mayuscula")
    @Size(max = 50,message = "No puede ser mayor a 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    @NotNull
    List<SubjectDTO> subjects;
}
