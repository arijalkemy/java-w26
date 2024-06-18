package com.mercadolibre.meli_frescos.dto.frescos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InboundOrderRequestDTO {
    @Valid
    @NotNull(message = "Inboud order cannot be null")
    @JsonProperty("inbound_order")
    private InboundOrderDTO inboundOrder;
}
