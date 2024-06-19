package com.mercadolibre.sprint3_individual_perez.projections;

import java.time.LocalDate;

public record BatchStockProjection(Long id, Integer currentQuantity, LocalDate dueDate) {

}
