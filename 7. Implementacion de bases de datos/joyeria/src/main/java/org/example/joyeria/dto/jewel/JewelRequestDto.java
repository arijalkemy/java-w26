package org.example.joyeria.dto.jewel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelRequestDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String source;
    @NotNull
    @Positive
    private Double weight;
    @NotEmpty
    private String specificity;
    @NotNull
    private Boolean stone;
    @NotNull
    private Boolean sell;
}
