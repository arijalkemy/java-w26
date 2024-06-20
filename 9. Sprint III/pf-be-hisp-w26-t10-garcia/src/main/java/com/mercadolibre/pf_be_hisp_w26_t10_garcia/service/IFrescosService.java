package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.ProductDto;

import java.util.Set;

public interface IFrescosService {
    public Set<ProductDto> getProductsFromShoppingCart(Integer id);
}
