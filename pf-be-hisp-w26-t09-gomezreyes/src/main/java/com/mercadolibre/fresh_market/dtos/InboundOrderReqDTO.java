package com.mercadolibre.fresh_market.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundOrderReqDTO implements Serializable {

    @JsonProperty("inbound_order")
    private InboundOrderDTO inboundOrderDTO;

}
