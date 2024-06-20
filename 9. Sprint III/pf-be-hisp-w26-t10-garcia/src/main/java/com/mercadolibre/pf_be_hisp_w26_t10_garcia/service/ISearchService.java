package com.mercadolibre.pf_be_hisp_w26_t10_garcia.service;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.BatchListProductDTO;

public interface ISearchService {
    BatchListProductDTO searchProduct(Integer id, String order);
}
