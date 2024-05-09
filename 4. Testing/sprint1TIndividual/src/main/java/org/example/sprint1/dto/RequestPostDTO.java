package org.example.sprint1.dto;

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

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestPostDTO {

    @JsonProperty("user_id")
    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero")
    private int userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;

    @Valid
    @NotNull
    private ProductDTO product;

    @Positive
    @NotNull(message = "El campo no puede estar vacío.")
    private int category;

    @Positive
    @NotNull(message = "El campo no puede estar vacío.")
    @Max(value = 10_000_000, message = "El precio máximo por producto es de 10.000.000")
    private double price;
}
