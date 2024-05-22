package com.implementaciondb.ejercicio10_showroom.model.dto.Sale;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.Valid;
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
public class SaleRequestDto {

    @JsonProperty("date")
    @NotNull(message = "La fecha es requerida")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    @JsonProperty("total")
    @NotNull(message = "El total es requerido")
    private Double total;

    @JsonProperty("payment_method")
    @NotNull(message = "El método de pago es requerido")
    private String paymentMethod;

    @Valid
    @JsonProperty("sale_details")
    @NotNull(message = "Los detalles de la venta son requeridos")
    private List<SaleDetailRequestDto> saleDetails;

}
