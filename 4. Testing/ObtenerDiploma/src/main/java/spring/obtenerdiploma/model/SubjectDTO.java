package spring.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Data
@Validated
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;

    @NotNull(message = "El puntaje no puede estar vacío")
    @DecimalMin(value = "0.0", inclusive = true, message = "El puntaje debe ser como mínimo 0.0")
    @DecimalMax(value = "10.0", inclusive = true, message = "El puntaje debe ser como máximo 10.0")
    Double score;
}
