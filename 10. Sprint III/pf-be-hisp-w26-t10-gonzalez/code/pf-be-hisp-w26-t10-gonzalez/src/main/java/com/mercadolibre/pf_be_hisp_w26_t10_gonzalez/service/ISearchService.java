package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.BatchListProductDTO;

public interface ISearchService {
    BatchListProductDTO searchProduct(Integer id, String order);
}
