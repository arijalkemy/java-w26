package com.mercadolibre.meli_frescos.dto.frescos;

import lombok.Data;

import java.util.List;

@Data
public class BatchSearchStockResponseDTO {
    List<BatchStockExtendedDTO>  batchStockExtendedDTOList;
}
