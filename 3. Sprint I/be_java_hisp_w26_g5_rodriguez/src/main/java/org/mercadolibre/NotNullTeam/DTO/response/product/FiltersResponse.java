package org.mercadolibre.NotNullTeam.DTO.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.response.brand.BrandBasicResponse;
import org.mercadolibre.NotNullTeam.DTO.response.type.TypeBasicResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FiltersResponse {
    private List<BrandBasicResponse> brands;
    private List<TypeBasicResponse> types;
    private long has_promo;
}
