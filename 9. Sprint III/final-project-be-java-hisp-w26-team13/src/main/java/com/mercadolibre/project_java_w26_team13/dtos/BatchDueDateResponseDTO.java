package com.mercadolibre.project_java_w26_team13.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDueDateResponseDTO {
    @JsonProperty("batch_stock")
    private List<BatchDueDateDTO> listBatchs;
}
