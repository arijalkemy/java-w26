package org.bootcamp.showroom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClothesRequestDto {
    private String code;
    private String name;
    private int type;
    private String brand;
    private String colour;
    private String waist;
    private int amount;
    private BigDecimal salePrice;
}
