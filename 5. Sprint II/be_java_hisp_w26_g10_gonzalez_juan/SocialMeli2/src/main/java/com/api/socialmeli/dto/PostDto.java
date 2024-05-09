package com.api.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    @NotNull(message = "El id no puede estar vacío")
    @Min(value = 0, message = "El id debe ser mayor a cero")
    private Integer user_id;


    private int post_id;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Valid
    private ProductDto product;

    @NotNull(message = "El campo no puede estar vacío.")
    private int category;

    @NotNull(message = "El campo no puede estar vacío.")
    @DecimalMax(value = "10000000", message = "El precio máximo por producto es de 10.000.000")
    private double price;
}
