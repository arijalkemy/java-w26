package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.buyers.BuyerResponseDto;

public interface IBuyerService {
    BuyerResponseDto findById(Long id);
}
