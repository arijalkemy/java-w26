package com.mercadolibre.project_be_java_hisp_w26_team5.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingOrderChangeStateRequestDTO {
    private String state;
}
