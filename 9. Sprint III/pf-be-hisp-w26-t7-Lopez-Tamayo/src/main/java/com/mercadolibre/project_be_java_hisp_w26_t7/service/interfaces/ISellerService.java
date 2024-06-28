package com.mercadolibre.project_be_java_hisp_w26_t7.service.interfaces;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.sellers.SellerResponseDto;

public interface ISellerService {
    SellerResponseDto findById(Long id);
}
