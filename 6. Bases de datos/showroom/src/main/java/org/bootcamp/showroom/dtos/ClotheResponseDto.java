package org.bootcamp.showroom.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.showroom.entities.ClotheType;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ClotheResponseDto {
    private Long id;
    private String code;
    private String name;
    private ClotheType type;
    private String brand;
    private String colour;
    private String waist;
    private int amount;
    private BigDecimal salePrice;
}

