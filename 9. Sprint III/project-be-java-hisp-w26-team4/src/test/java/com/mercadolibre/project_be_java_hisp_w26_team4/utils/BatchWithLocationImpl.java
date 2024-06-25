package com.mercadolibre.project_be_java_hisp_w26_team4.utils;

import com.mercadolibre.project_be_java_hisp_w26_team4.model.projection.BatchWithLocation;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BatchWithLocationImpl implements BatchWithLocation {
    Long warehouseId;
    Long sectionId;
    Long productId;
    Long batchId;
    Integer currentQuantity;
    LocalDate dueDate;

    @Override
    public Long getWarehouseId() {
        return warehouseId;
    }

    @Override
    public Long getSectionId() {
        return sectionId;
    }

    @Override
    public Long getProductId() {
        return productId;
    }

    @Override
    public Long getBatchId() {
        return batchId;
    }

    @Override
    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    @Override
    public LocalDate getDueDate() {
        return dueDate;
    }
}
