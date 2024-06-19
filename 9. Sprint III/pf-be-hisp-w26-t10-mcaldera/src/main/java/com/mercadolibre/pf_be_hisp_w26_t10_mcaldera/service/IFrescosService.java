package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.ProductDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.PurchaseOrderDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.PurchaseValueResponseDto;

import java.util.Set;

public interface IFrescosService {
    public PurchaseValueResponseDto createOrder(PurchaseOrderDto order);
    public Set<ProductDto> getProductsFromShoppingCart(Integer id);
}
