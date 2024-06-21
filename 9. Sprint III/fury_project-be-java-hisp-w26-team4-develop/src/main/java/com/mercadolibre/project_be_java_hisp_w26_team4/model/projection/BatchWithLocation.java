package com.mercadolibre.project_be_java_hisp_w26_team4.model.projection;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
