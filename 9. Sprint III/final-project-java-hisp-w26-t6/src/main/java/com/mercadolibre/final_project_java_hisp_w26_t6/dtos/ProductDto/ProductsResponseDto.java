package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponseDto implements Serializable {
    private List<ProductDto> products;
}
