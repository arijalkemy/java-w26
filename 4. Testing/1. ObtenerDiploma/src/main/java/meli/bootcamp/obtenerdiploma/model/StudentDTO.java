package meli.bootcamp.obtenerdiploma.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;

import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del estudiante no puede estar vacío")
    @NotBlank(message = "El nombre del estudiante no puede estar en blanco")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    List<SubjectDTO> subjects;
}
