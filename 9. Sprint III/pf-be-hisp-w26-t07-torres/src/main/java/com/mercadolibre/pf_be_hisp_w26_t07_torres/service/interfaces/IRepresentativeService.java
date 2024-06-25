package com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.representatives.RepresentativeResponseDto;

public interface IRepresentativeService {
    RepresentativeResponseDto findById(Long id);
}
