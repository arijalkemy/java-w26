package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseOrderCreatedResponseDTO {
    @JsonProperty("id_purchase_order")
    private Integer id;

    @JsonProperty("total_price")
    private Double totalPrice;

    @JsonProperty("products_without_stock")
    private List<String> productsWithoutStock;
}
