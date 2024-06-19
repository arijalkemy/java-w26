package com.mercadolibre.fresh_market.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


import lombok.Builder;

@Builder
public record ProjectionPurchaseOrder(Long id, String orderStatus, LocalDate date,  List<ProjectionCartDetail> cartDetails) implements Serializable {
}
