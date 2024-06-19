package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

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
