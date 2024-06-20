package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchResponseDto {

    List<BatchDto> batch_stock;
}
