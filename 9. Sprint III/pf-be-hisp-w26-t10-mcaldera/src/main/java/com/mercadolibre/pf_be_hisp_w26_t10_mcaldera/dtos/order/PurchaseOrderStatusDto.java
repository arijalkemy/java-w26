package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderStatusDto {
    private String status_code;
}
