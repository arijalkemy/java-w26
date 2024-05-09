package org.example.SocialMeli2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * DTO para la solicitud de creación de un Post.
 * Este DTO se utiliza para representar la información necesaria para crear un nuevo post.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestPostDTO {

    /**
     * El ID del usuario que crea el post.
     * Este campo no puede estar vacío y debe ser mayor a cero.
     */
    @JsonProperty("user_id")
    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    private int userId;

    /**
     * La fecha en que se crea el post.
     * Este campo no puede estar vacío.
     */
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;

    /**
     * El producto que se está vendiendo en el post.
     * Este campo es validado para asegurar que es un producto válido.
     */
    @Valid
    @NotNull
    private ProductDTO product;

    /**
     * La categoría del producto.
     * Este campo no puede estar vacío y debe ser mayor a cero.
     */
    @Positive
    @NotNull(message = "El campo no puede estar vacío.")
    private int category;

    /**
     * El precio del producto.
     * Este campo no puede estar vacío, debe ser mayor a cero y no puede superar los 10.000.000.
     */
    @Positive
    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10_000_000, message = "El precio máximo por producto es de 10.000.000")
    private double price;
}
