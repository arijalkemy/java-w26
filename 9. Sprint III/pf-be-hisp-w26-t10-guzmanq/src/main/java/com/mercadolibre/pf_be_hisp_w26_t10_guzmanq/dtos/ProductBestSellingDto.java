package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBestSellingDto {
    private double quantity;
    private Product product;
}
