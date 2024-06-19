package com.mercadolibre.sprint3_individual_perez.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint3_individual_perez.dto.request.BatchDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor @Builder
public class InboundResponseDTO {
    @NotNull
    @JsonProperty("batch_stock")
    private List<BatchDTO> batchDTOList;
}
