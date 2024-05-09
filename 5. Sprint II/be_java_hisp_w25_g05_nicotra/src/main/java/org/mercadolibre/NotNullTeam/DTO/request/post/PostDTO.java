package org.mercadolibre.NotNullTeam.DTO.request.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.product.ProductDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @NotNull(message = "El id no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    @JsonProperty("user_id")
    private Long userId;

    @NotEmpty(message = "La fecha no puede estar vacía.")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$", message = "El formato debe ser dd-MM-YYYY")
    private String date;

    @Valid
    ProductDTO product;

    @NotNull(message = "La categoría no puede estar vacía.")
    @Min(value = 1, message = "La categoría debe ser mayor a cero.")
    private int category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Positive(message = "El precio no puede ser negativo.")
    @Max(value = 10_000_000, message = "El precio máximo por producto es de $10.000.000")
    private Double price;


}
