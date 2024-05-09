package org.example.SocialMeli2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entidad para un Post.
 * Esta entidad se utiliza para representar la información de un post en el sistema.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"postId", "date", "product", "category", "price", "hasPromo", "discount"})
@Builder
public class Post {
    /**
     * El ID del post.
     */
    @JsonProperty("post_id")
    private int postId;

    /**
     * La fecha en que se creó el post.
     */
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    /**
     * El producto que se está vendiendo en el post.
     */
    private Product product;

    /**
     * La categoría del producto.
     */
    private int category;

    /**
     * El precio del producto.
     */
    private double price;

    /**
     * Indica si el post tiene una promoción.
     */
    @JsonProperty("has_promo")
    private boolean hasPromo;

    /**
     * El descuento aplicado al producto en caso de que haya una promoción.
     */
    private double discount;
}
