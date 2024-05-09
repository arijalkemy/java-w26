package org.example.social_meli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer post_id;
    @NotNull(message="El  id no puede estar vacío")
    @Min(value=0, message="El id debe ser mayor a cero")
    private Integer user_id;
    @NotNull(message = "La fecha no puede estar vacía")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    @NotNull(message="El  campo no puede estar vacío")
    private Integer category;
    @NotNull(message = "El campo no puede estar vacío")
    @DecimalMax(value="10000000",message = "El precio máximo por producto es de 10.000.000")
    private Double price;
}
