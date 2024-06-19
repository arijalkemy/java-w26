package com.mercadolibre.sprint3_individual_perez.dto.request;

import com.mercadolibre.sprint3_individual_perez.enums.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductRequestDTO {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    @Positive
    private Double price;
    @NotNull
    @NotEmpty
    private Category type;
}
