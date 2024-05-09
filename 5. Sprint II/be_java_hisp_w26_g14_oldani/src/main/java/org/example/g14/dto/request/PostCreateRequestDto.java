package org.example.g14.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.g14.dto.ProductDto;
import org.example.g14.utils.ValidationMessages;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateRequestDto {

    @JsonProperty("user_id")
    @NotNull(message = ValidationMessages.ID_NOT_EMPTY)
    @Positive(message = ValidationMessages.ID_POSITIVE)
    private Integer idUser;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "La fecha no puede estar vacía.")
    private LocalDate date;

    @NotNull(message = "El producto no puede estar vacío.")
    @Valid
    private ProductDto product;

    @NotNull(message = ValidationMessages.FIELD_NOT_EMPTY)
    private Integer category;

    @NotNull(message = ValidationMessages.FIELD_NOT_EMPTY)
    @Max(value = 10_000_000, message = "El precio máximo por producto es de 10.000.000.")
    private Double price;
}
