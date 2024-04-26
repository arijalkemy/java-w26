package org.mercadolibre.NotNullTeam.DTO.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterProductsResponse {
    private FiltersResponse filters;
    private List<MainProductResponse> products;
}
