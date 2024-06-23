package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingOrderChangeStateRequestDTO {
    private String state;
}
