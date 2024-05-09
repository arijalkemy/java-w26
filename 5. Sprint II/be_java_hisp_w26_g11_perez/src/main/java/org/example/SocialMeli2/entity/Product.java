package org.example.SocialMeli2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad para un Producto.
 * Esta entidad se utiliza para representar la información de un producto en el sistema.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"productId", "productName", "type", "brand", "color", "notes"})
@Builder
public class  Product {
    /**
     * El ID del producto.
     */
    @JsonProperty("product_id")
    private int productId;

    /**
     * El nombre del producto.
     */
    @JsonProperty("product_name")
    private String productName;

    /**
     * El tipo de producto.
     */
    private String type;

    /**
     * La marca del producto.
     */
    private String brand;

    /**
     * El color del producto.
     */
    private String color;

    /**
     * Notas adicionales sobre el producto.
     */
    private String notes;
}
