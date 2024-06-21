package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchWithLocation {

    Long warehouseId;

    Long sectionId;

    Long productId;

    Long batchId;

    Integer currentQuantity;

    LocalDate dueDate;
}
