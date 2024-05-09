package org.example.social_meli.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
     @NotNull(message="El  id no puede estar vacío")
     @Min(value=0, message="El id debe ser mayor a cero")
     private Integer product_id;
     @NotNull(message="El campo no puede estar vacío")
     @Max(value=40, message="La longitud no puede superar 40 caracteres")
     @Pattern(regexp = "[\\p{L}0-9 ]+", message = "El campo no puede poseer caracteres especiales")
     private String product_name;
     @NotNull(message="El campo no puede estar vacío")
     @Max(value=15, message="La longitud no puede superar los 15 caracteres")
     @Pattern(regexp = "[\\p{L}0-9 ]+", message = "El campo no puede poseer caracteres especiales")
     private String type;
     @NotNull(message="El campo no puede estar vacío")
     @Max(value=25, message="La longitud no puede superar los 25 caracteres")
     @Pattern(regexp = "[\\p{L}0-9 ]+", message = "El campo no puede poseer caracteres especiales")
     private String brand;
     @NotNull(message="El campo no puede estar vacío")
     @Max(value=15, message="La longitud no puede superar los 15 caracteres")
     @Pattern(regexp = "[\\p{L}0-9 ]+", message = "El campo no puede poseer caracteres especiales")
     private String color;
     @Max(value=80, message="La longitud no puede superar los 80 caracteres")
     @Pattern(regexp = "[\\p{L}0-9 ]+", message = "El campo no puede poseer caracteres especiales")
     private String notes;
}
