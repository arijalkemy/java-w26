package com.mercadolibre.pf_be_hisp_w26_t10_imbachi.service;

import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.ProductDto;

import java.util.Set;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.PurchaseOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t10_imbachi.dtos.PurchaseValueResponseDto;

public interface IFrescosService {
    public PurchaseValueResponseDto createOrder(PurchaseOrderDto order);
    public Set<ProductDto> getProductsFromShoppingCart(Integer id);
}
