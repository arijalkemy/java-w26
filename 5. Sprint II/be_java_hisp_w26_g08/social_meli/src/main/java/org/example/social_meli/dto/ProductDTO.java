package org.example.social_meli.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    @Positive(message = "El id debe ser mayor a 0")
    @NotNull(message = "El id no puede ser vacío")
    private Integer product_id;

    @Pattern(regexp = "[\\p{L}0-9 ]+", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 40, message = "La longitud no puede superar los 40 carácteres")
    private String  product_name;

    @NotBlank(message = "El tipo del producto no puede estar vacío")
    @NotNull(message = "El campo no puede ser nulo")
    @Pattern(regexp = "[\\p{L}0-9 ]+", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 15, message = "La longitud no puede superar los 15 carácteres")
    private String type;

    @NotBlank(message = "La marca del producto no puede estar vacío")
    @NotNull(message = "El campo no puede ser nulo")
    @Pattern(regexp = "[\\p{L}0-9 ]+", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 25, message = "La longitud no puede superar los 25 carácteres")
    private String brand;

    @NotBlank(message = "El color del producto no puede estar vacío")
    @NotNull(message = "El campo no puede ser nulo")
    @Pattern(regexp = "[\\p{L}0-9 ]+", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 15, message = "La longitud no puede superar los 15 carácteres")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 carácteres")
    @Pattern(regexp = "[\\p{L}0-9 ]+", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
