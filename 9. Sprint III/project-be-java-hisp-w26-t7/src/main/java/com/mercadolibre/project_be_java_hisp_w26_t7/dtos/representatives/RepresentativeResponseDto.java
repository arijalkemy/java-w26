package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.representatives;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class RepresentativeResponseDto {
    private Long id;
    private String name;
}
