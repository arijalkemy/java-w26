package com.implementaciondb.ejercicio10_showroom.model.dto.Sale;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponseDto {

    @JsonProperty("number")
    private Long number;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("total")
    private Double total;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("sale_details")
    private List<SaleDetailResponseDto> saleDetails;

}
