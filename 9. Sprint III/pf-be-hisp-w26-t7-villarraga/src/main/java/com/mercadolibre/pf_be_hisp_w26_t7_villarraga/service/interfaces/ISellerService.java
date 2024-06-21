package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service.interfaces;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.sellers.SellerResponseDto;

public interface ISellerService {
    SellerResponseDto findById(Long id);
}
