package org.example.be_java_hisp_w26_g04.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {
    @NotNull(message = "El campo no puede estar vacío.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = "La fecha no debe estar vacía.")
    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull(message = "El campo no puede estar vacío")
    @JsonProperty("category")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío")
    @DecimalMin(value = "0.01", message = "El precio minimo debe ser mayor a 0.01")
    @DecimalMax(value = "10000000.00", message = "El precio máximo por producto es de 10.000.000")
    @JsonProperty("price")
    private Double price;

    @Valid
    @JsonProperty("product")
    private ProductDTO product;
}
