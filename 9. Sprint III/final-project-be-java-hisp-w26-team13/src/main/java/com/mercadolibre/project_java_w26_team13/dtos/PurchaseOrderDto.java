package com.mercadolibre.project_java_w26_team13.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseOrderDto {
    @NotNull(message = "Date can not be empty.")
    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String date;
    @NotNull(message = "Buyer Id can not be empty.")
    @Positive(message = "Buyer Id must be positive.")
    @JsonProperty("buyer_id")
    private int buyerId;
    @NotNull(message = "Order status can not be empty.")
    @JsonProperty("order_status")
    private OrderStatusDto orderStatusDto;
    @NotNull
    private List<CartProductDto> products;
}
