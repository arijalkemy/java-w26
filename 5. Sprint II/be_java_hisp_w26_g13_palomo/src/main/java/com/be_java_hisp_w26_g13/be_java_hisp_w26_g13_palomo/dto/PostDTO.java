package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PostDTO implements Serializable {
    @JsonProperty("post_id")
    private int postId;

    @JsonProperty("user_id")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private int userId;

    @NotNull(message = "La fecha no puede estar vacía.")
    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull(message = "El campo no puede estar vacio")
    @JsonProperty("product")
    private @Valid ProductDTO product;

    @NotNull(message = "El campo no puede estar vacio.")
    @Positive(message = "El campo debe ser mayor a cero")
    @JsonProperty("category")
    private int category;

    @NotNull(message = "El campo no puede estar vacio")
    @Positive(message = "El campo debe ser mayor a cero")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    @JsonProperty("price")
    private double price;
}
