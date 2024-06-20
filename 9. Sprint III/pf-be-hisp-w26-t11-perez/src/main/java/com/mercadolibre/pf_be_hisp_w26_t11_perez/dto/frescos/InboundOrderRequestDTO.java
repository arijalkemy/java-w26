package com.mercadolibre.pf_be_hisp_w26_t11_perez.dto.frescos;

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
