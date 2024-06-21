package com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class BatchWrongTemperatureDTO {
    Integer batch_number;
    Double current_temperature;
    Double minimum_temperature;
    Double degrees_above_minimum;
    Integer current_quantity;
}
