package com.example.sprint1.dto;

import com.example.sprint1.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Integer id;

    @NotBlank(message = "El id no puede estar vacío.")
    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer user_id;

    @NotBlank(message = "La fecha no puede estar vacía.")
    @NotNull(message = "La fecha no puede estar vacía.")
    @Pattern(regexp = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$", message = "La fecha debe tener el formato dd-mm-yyyy")
    private String date;

    @NotBlank(message = "La category no puede estar vacío.")
    @NotNull(message = "La category no puede estar vacío.")
    private Integer category;

    @NotBlank(message = "El price no puede estar vacío.")
    @NotNull(message = "El price no puede estar vacío.")
    @DecimalMax(value = "10000000.00", message = "El precio máximo es de 10,000,000.00")
    @DecimalMin(value = "0.01", message = "El precio mínimo es de 0.01")
    private Double price;

    @NotNull(message = "El product no puede estar vacío.")
    private ProductDto product;
}
