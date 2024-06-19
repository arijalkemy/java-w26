package com.mercadolibre.pf_be_hisp_w26_t11_acontrerasc.dto.frescos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private Integer id;
    @NotNull(message= "Product name is required")
    private String name;
    @NotNull(message= "Product price is required")
    private Double price;


    public ProductRequestDto( String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
