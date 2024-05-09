package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * DTO para la entidad Product.
 * Este DTO se utiliza para representar la información de un producto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"productId", "productName", "type", "brand", "color", "notes"})
public class  ProductDTO {

    /**
     * El ID del producto.
     * Este campo no puede estar vacío y debe ser mayor a cero.
     */
    @JsonProperty("product_id")
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero")
    private int productId;

    /**
     * El nombre del producto.
     * Este campo no puede estar vacío y su longitud no puede superar los 40 caracteres.
     * No puede contener caracteres especiales.
     */
    @JsonProperty("product_name")
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Length(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String productName;

    /**
     * El tipo de producto.
     * Este campo no puede estar vacío y su longitud no puede superar los 15 caracteres.
     * No puede contener caracteres especiales.
     */
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Length(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    /**
     * La marca del producto.
     * Este campo no puede estar vacío y su longitud no puede superar los 25 caracteres.
     * No puede contener caracteres especiales.
     */
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Length(max = 15, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    /**
     * El color del producto.
     * Este campo no puede estar vacío y su longitud no puede superar los 15 caracteres.
     * No puede contener caracteres especiales.
     */
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Length(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    /**
     * Notas adicionales sobre el producto.
     * Este campo es opcional y su longitud no puede superar los 80 caracteres.
     * No puede contener caracteres especiales.
     */
    @Length(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
