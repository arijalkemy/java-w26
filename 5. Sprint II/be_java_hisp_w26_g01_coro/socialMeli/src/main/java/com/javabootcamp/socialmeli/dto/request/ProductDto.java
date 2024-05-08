package com.javabootcamp.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    @JsonProperty("product_id")
    @NotNull(message = "La id no puede estar vacía")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private Integer id;

    @JsonProperty("product_name")
    @Size( max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El campo no puede poseer caracteres especiales.")
    private String name;

    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
