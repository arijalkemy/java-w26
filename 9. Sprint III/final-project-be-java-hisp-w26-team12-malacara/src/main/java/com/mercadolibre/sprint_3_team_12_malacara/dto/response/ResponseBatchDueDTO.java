package com.mercadolibre.sprint_3_team_12_malacara.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseBatchDueDTO {
    @JsonProperty("batch_stock")
    private List<BatchDueDTO> batchDueDTOList;

}
