package com.mercadolibre.project_be_java_hisp_w26_team5.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilterRequestDTO {

    @JsonProperty("id_seller")
    private Integer idSeller;

    private String name;

    @JsonProperty("min_price")
    @Positive
    private Double minPrice;

    @JsonProperty("max_price")
    @Positive
    private Double maxPrice;

    private List<String> type;


}
