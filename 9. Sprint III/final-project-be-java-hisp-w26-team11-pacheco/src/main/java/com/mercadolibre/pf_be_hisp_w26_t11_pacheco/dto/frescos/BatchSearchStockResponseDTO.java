package com.mercadolibre.pf_be_hisp_w26_t11_pacheco.dto.frescos;

import lombok.Data;

import java.util.List;

@Data
public class BatchSearchStockResponseDTO {
    List<BatchStockExtendedDTO>  batchStockExtendedDTOList;
}
