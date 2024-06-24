package com.mercadolibre.project_java_w26_team13.dtos.projections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public interface BatchDueDateProjection {
    String getBatchNumber();
    Integer getCurrentQuantity();
    Integer getProductId();
    Integer getProductTypeId();
    LocalDate getDueDate();
}
