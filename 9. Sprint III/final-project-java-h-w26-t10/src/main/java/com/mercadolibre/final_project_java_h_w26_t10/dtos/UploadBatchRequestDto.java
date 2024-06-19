package com.mercadolibre.final_project_java_h_w26_t10.dtos;

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
