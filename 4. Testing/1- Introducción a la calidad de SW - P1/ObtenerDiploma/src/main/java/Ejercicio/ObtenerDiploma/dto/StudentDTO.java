package Ejercicio.ObtenerDiploma.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Serializable {
    @Size(min = 1, max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @Pattern(regexp = "[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula")
    @NotBlank(message = "El nombre del alumno no puede estar vacio")
    String studentName;
    String message;
    Double averageScore;

    @NotNull(message = "La lista de materias no puede ser nula")
    @Size(min = 1, message = "Debe haber al menos una materia")
    List<SubjectDTO> subjects;
}
