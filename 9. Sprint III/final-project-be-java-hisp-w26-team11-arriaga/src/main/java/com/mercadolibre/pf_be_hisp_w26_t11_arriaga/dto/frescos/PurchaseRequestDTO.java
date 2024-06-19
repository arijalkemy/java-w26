package com.mercadolibre.pf_be_hisp_w26_t11_arriaga.dto.frescos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseRequestDTO {
    @JsonProperty("purchase_order")
    private PurchaseOrderDTO purchaseOrder;
}
