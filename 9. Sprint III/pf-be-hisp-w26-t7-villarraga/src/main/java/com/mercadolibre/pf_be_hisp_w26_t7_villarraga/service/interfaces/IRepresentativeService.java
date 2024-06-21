package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.representatives.RepresentativeResponseDto;

public interface IRepresentativeService {
    RepresentativeResponseDto findById(Long id);
}
