package Ejercicio.ObtenerDiploma.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO implements Serializable {
    @Size(min = 1, max = 30)
    @NotBlank(message = "El nombre de la asignatura no puede estar en blanco")
    @Pattern(regexp = "[A-Z].*", message = "El primer carácter debe ser una letra mayúscula")
    String name;

    @NotBlank(message = "La asignatura de la asignatura no puede estar en blanco")
    @DecimalMin(value = "0.0", inclusive = true, message = "La calificación mínima debe ser 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "La calificación máxima debe ser 10.0")
    double score;
}
