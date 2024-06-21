package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.representatives;

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
