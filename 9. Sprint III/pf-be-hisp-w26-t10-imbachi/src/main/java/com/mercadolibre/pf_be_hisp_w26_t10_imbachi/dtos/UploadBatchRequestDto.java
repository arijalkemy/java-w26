package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadBatchRequestDto {

    @NotBlank(message = "inbound_order is required")
    @JsonProperty("inbound_order")
    InboundOrderDto inboundOrderDto;

}
