package com.mercadolibre.pf_be_hisp_w26_t1_cassini.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class BatchWrongTemperatureRespDTO {
    Integer product_id;
    List<BatchWrongTemperatureDTO> batch_stock;
}
