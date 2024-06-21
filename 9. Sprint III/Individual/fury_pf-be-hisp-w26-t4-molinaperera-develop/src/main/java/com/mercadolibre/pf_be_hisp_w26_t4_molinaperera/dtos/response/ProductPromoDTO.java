package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPromoDTO {

    @JsonProperty("product_id")
    private Long id;
    @JsonProperty("product_type")
    private ProductType productType;
    @JsonProperty("product_description")
    private String description;
    @JsonProperty("product_price_original")
    private Double priceOriginal;
    @JsonProperty("product_price_promo")
    private Double pricePromo;
    @JsonProperty("product_start_date")
    private LocalDate startDate;
    @JsonProperty("product_end_date")
    private LocalDate endDate;
}
