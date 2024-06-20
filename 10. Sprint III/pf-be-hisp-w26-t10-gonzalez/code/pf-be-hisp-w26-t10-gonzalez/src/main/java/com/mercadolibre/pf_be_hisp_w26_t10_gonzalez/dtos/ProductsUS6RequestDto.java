package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsUS6RequestDto {
    private List<ProductUS6Dto> products;
}
