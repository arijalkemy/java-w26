package org.mercadolibre.NotNullTeam.DTO.response.type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeBasicResponse {
    private String name;
    private long amount;
}
