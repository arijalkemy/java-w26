package com.mercadolibre.final_project_java_h_w26_t10.service;

import com.mercadolibre.final_project_java_h_w26_t10.dtos.BatchListProductDTO;

public interface ISearchService {
    BatchListProductDTO searchProduct(Integer id, String order);
}
