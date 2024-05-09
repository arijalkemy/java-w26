package com.example.sprint1.dto;

import com.example.sprint1.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotNull(message = "El id no puede estar vacío.")
    @NotBlank(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer id;

    @NotBlank(message = "El campo no puede estar vacío.")
    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre del producto no puede superar los 30 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9 áéíóúÁÉÍÓÚüÜñÑ]*$", message = "El nombre del producto no puede poseer caracteres especiales.")
    private String product_name;

    @NotBlank(message = "El campo no puede estar vacío.")
    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud de [type] no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9 áéíóúÁÉÍÓÚüÜñÑ]*$", message = "El campo [type] no puede poseer caracteres especiales.")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío.")
    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud de [brand] no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9 áéíóúÁÉÍÓÚüÜñÑ]*$", message = "El campo [brand] no puede poseer caracteres especiales.")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío.")
    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud de [color] no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9 áéíóúÁÉÍÓÚüÜñÑ]*$", message = "El campo [color] no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud de [notes] no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9 áéíóúÁÉÍÓÚüÜñÑ]*$", message = "El campo [notes] no puede poseer caracteres especiales.")
    private String notes;
}
