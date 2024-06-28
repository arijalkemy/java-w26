package com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.representatives.RepresentativeResponseDto;

public interface IRepresentativeService {
    RepresentativeResponseDto findById(Long id);
}
