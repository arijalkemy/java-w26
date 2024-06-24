package com.mercadolibre.pf_be_hisp_w26_t01_ditta.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SectionResponseDTO {
    Integer idSection;
    String nameWarehouse;
    String nameCategory;
    Integer maxBatchCapacity;
}
