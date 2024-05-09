package com.api.socialmeli.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @NotNull(message = "El campo no puede esta vacio.")
    Integer product_id;

    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$", message = "El campo no puede poseer caracteres especiales.")
    private String product_name;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    private String color;

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    private String notes;

}
