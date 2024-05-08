package org.example.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {
    public static final int MAX_PRICE_VALUE = 10000000;
    @Positive (message = "El id debe ser mayor a 0")
    @NotNull (message = "El id no puede ser vacío")
    private Integer post_id;

    @Positive (message = "El id debe ser mayor a 0")
    @NotNull(message = "El id no puede ser vacío")
    private Integer user_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía")
    private LocalDate date;

    private ProductDTO product;

    @NotNull (message = "El campo no puede estar vacío")
    @Positive (message = "El id de categoría debe ser positivo")
    private Integer category;

    @Positive
    @Max(value = MAX_PRICE_VALUE, message = "El precio máximo por producto es de "+MAX_PRICE_VALUE)
    private Double price;
}
