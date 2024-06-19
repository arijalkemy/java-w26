package com.mercadolibre.sprint3_individual_perez.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint3_individual_perez.dto.request.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class ResponseProductDTO {
    @JsonProperty("products")
    List<ProductDTO> productDTOList;
}
