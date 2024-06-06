package org.example.integradorproductemployee.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private String type;
    private Double sellPrice;
    private Double fabricationPrice;
    private Integer stock;
}
