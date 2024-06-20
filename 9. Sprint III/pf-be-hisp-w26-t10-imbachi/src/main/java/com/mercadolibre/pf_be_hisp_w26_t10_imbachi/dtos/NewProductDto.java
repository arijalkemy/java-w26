package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewProductDto {
    private Integer id;
    private String name;
    private Double price;
}
