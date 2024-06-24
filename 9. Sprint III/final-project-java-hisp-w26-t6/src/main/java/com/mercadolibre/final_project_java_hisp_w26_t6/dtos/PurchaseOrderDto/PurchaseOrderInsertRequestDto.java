package com.mercadolibre.final_project_java_hisp_w26_t6.dtos.PurchaseOrderDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderInsertRequestDto implements Serializable {
    @NotNull(message = "La orden no puede estar vacia")
    @JsonProperty("purchase_order")
    @Valid
    private PurchaseOrderDto purchaseOrderDto;
}
