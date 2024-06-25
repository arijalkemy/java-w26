package com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.sellers.SellerResponseDto;

public interface ISellerService {
    SellerResponseDto findById(Long id);
}
