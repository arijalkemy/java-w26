package com.mercadolibre.project_be_java_hisp_w26_team4.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderRequestDTO {
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("date")
    @NotNull(message = "Date cannot be null")
    private LocalDate date;
    @JsonProperty("buyer_id")
    @NotNull(message = "Buyer ID cannot be null")
    private Long buyerId;
    @JsonProperty("order_status")
    @NotNull(message = "Status cannot be null")
    private OrderStatusRequestDTO status;
    @JsonProperty("products")
    @NotEmpty(message = "Products list must not be empty")
    private List<@Valid ProductOrderRequestDTO> products;
}
