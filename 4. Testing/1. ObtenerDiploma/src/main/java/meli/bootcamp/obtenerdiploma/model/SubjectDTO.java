package meli.bootcamp.obtenerdiploma.model;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    @NotEmpty
    @NotBlank
    String name;
    @PositiveOrZero @Min(0) @Max(10)
    Double score;
}
