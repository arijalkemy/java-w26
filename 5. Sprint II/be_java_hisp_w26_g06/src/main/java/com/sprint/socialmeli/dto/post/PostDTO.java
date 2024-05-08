package com.sprint.socialmeli.dto.post;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class PostDTO implements Serializable {

    @NotNull(message = "El user_id no puede estar vacío")
    @Positive(message = "El user_id debe ser mayor a cero")
    private final Integer user_id;

    @NotBlank(message = "La fecha no puede estar vacía")
    private final String date; //Entra como dd/MM/yyyy

    @Valid
    @NotNull(message = "El campo producto no puede estar vacío")
    private final ProductDTO product;

    @NotNull(message = "El campo category no puede estar vacío")
    private final Integer category;

    @NotNull(message = "El campo price no puede estar vacío")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private final Double price;
}
