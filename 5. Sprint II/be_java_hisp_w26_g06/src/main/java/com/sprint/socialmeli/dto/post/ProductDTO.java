package com.sprint.socialmeli.dto.post;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Data
public class ProductDTO implements Serializable {

    @NotNull(message = "El campo product_id no puede estar vacío")
    @Positive(message = "El product_id debe ser mayor a cero")
    private final Integer product_id;

    @NotBlank(message = "El campo product_name no puede estar vacío")
    @Length(max = 40, message = "La longitud de product_name no puede superar los {max} caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "El campo product_name no puede poseer caracteres especiales")
    private final String product_name;

    @NotBlank(message = "El campo type no puede estar vacío")
    @Length(max = 15, message = "La longitud de product_name no puede superar los {max} caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "El campo product_name no puede poseer caracteres especiales")
    private final String type;

    @NotBlank(message = "El campo brand no puede estar vacío")
    @Length(max = 25, message = "La longitud de brand no puede superar los {max} caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "El campo brand no puede poseer caracteres especiales")
    private final String brand;

    @NotBlank(message = "El campo color no puede estar vacío")
    @Length(max = 15, message = "La longitud de color no puede superar los {max} caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "El campo color no puede poseer caracteres especiales")
    private final String color;

    //@NotBlank(message = "El campo notes no puede estar vacío")
    @Length(max = 80, message = "La longitud de notes no puede superar los {max} caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo notes no puede poseer caracteres especiales")
    private final String notes;
}
