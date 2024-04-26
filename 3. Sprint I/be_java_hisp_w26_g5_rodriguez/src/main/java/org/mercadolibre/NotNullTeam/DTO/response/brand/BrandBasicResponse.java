package org.mercadolibre.NotNullTeam.DTO.response.brand;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandBasicResponse {
    private String name;
    private long amount;
}
