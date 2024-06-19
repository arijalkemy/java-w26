package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos;

import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerProductRequestDto {
    private List<ProductDto> products;
}
