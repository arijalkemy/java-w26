package org.mercadolibre.NotNullTeam.DTO.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.response.brand.BrandBasicResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterProducts {
    private List<BrandBasicResponse> brands;
    private List<MainProductResponse> products;
}
