package com.mercadolibre.project_java_w26_team13.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.project_java_w26_team13.dtos.request.BatchStockDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatcheStockDTO {
    @JsonProperty("batch_stock")
    List<BatchStockDto> batchStock;
}
