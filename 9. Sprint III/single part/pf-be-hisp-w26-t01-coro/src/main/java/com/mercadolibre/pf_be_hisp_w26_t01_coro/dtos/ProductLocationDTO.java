package com.mercadolibre.pf_be_hisp_w26_t01_coro.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductLocationDTO {
    private SectionDTO section;
    private Integer productId;
    private List<BatchLocationDTO> batchStock;
}
