package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.*;
import org.example.SocialMeli2.entity.Product;

import java.time.LocalDate;

/**
 * DTO para la entidad Post.
 * Este DTO se utiliza para representar la información de un post de un vendedor.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    /**
     * El ID del vendedor que creó el post.
     */
    @JsonProperty("user_id")
    private int sellerId;

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
     * Este campo es validado para asegurar que es un producto válido.
     */
    @Valid
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
     * Indica si el post tiene una promoción activa.
     */
    @JsonProperty("has_promo")
    private boolean hasPromo;

    /**
     * El descuento aplicado al producto si tiene una promoción activa.
     */
    private double discount;
}
