package com.mercadolibre.sprint_3_valderrama.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class InboundDTO {
    @JsonProperty("inbound_order")
    private InboundOrderDTO inboundOrder;
}
