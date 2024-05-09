package bootcamp.sprint.grupo02.sprintI.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    @JsonProperty("user_id")
    @Positive(message = "El Id debe ser mayor a cero")
    @NotNull(message = "El id no puede estar vacio")
    private Integer userId;
    @NotBlank(message = "La fecha no puede estar vacia")
    private String date;
    @Valid
    private ProductDTO product;

    @NotNull(message = "El campo no puede estar vacio")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacio")
    @Max(value = 10000000, message = "El precio maximo por producto es de 10.000.000")
    private Double price;
}
