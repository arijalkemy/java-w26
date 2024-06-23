package com.mercadolibre.sprint_3_valderrama.projections;

import java.time.LocalDate;

public record BatchStockProjection(Long id, Integer currentQuantity, LocalDate dueDate) {

}
