package com.mercadolibre.pf_be_hisp_w26_t07_torres.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.buyers.BuyerResponseDto;

public interface IBuyerService {
    BuyerResponseDto findById(Long id);
}
