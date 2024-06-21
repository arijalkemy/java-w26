package com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BatchUpdateTemperatureReqDTO {
    @NotNull
    @Min(value = 1)
    @JsonProperty("new_temperature")
    private Double newTemperature;
}
