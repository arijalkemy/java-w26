package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.BatchListProductDTO;

public interface ISearchService {
    BatchListProductDTO searchProduct(Integer id, String order);
}
