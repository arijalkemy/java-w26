package com.mercadolibre.sprint_3_team_12.projections;

import java.time.LocalDate;

public record BatchStockProjection(Long id, Integer currentQuantity, LocalDate dueDate) {

}
