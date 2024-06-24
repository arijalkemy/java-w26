package com.mercadolibre.project_java_w26_team13.dtos.projections;

import java.time.LocalDate;

public interface BatchDueDateOrderProjection {
    String getBatchNumber();
    Integer getCurrentQuantity();
    Integer getProductId();
    Integer getProductTypeId();
    LocalDate getDueDate();
    String getSectionName();
}
