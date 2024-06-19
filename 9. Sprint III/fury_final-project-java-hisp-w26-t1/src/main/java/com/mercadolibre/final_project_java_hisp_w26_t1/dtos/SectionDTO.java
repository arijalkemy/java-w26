package com.mercadolibre.final_project_java_hisp_w26_t1.dtos;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SectionDTO {
    Integer section_code;
    Integer warehouse_code;
}
