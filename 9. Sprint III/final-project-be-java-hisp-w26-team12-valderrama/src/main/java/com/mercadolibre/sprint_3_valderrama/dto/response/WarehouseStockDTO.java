package com.mercadolibre.sprint_3_valderrama.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint_3_valderrama.dto.SectionDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseStockDTO {

    @JsonProperty("section")
    SectionDTO sectionDTO;

    @JsonProperty("product_id")
    Integer idProduct;

    @JsonProperty("batch_stock")
    private List<ResponseBatchDTO> batchDTOList;

}
