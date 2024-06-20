package com.mercadolibre.sprint_3_team_12.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ProductCreationResponseDTO {
    Integer operation;
    String message;
    Integer code;
}
