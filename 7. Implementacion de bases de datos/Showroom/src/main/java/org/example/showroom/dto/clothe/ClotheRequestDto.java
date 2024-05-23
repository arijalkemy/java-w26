package org.example.showroom.dto.clothe;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClotheRequestDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String type;
    @NotEmpty
    private String brand;
    @NotEmpty
    private String color;
    @NotEmpty
    private String size;
    @Positive
    private Integer amount;
    @Positive
    private Double price;
}
